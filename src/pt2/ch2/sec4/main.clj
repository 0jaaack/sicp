(ns pt2.ch2.sec4.main
  (:require [pt2.ch2.sec4.ex2.44 :refer [up-split]]
            [pt2.ch2.sec4.ex2.46 :refer [add-vect scale-vect xcor-vect ycor-vect, sub-vect, make-vect]]
            [pt2.ch1.sec2.ex2.2 :refer [start-segment, end-segment]]))

(defn wave []) ; dummy implementation
(defn flip-vert [painter] painter) ; dummy implementation
(defn flip-horiz [painter] painter) ; dummy implementation
(defn rotate180 [painter] painter) ; dummy implementation
(defn beside [painter1 painter2] painter1) ; dummy implementation
(defn below [painter1 painter2] painter1) ; dummy implementation

(defn wave2 []
  (beside wave (flip-vert wave)))

(defn wave4 []
  (below wave2 wave2))

(defn flipped-pairs [painter]
  (let [painter2 (beside painter (flip-vert painter))]
    (below painter2 painter2)))

(defn wave4 []
  (flipped-pairs wave))

(defn right-split [painter n]
  (if (= n 0)
    painter
    (let [smaller (right-split painter (- n 1))]
      (beside painter (below smaller smaller)))))



(defn corner-split [painter n]
  (if (= n 0)
    painter
    (let [up (up-split painter (- n 1))
          right (right-split painter (- n 1))]
      (let [top-left (beside up up)
            bottom-right (below right right)
            corner (corner-split painter (- n 1))]
        (beside (below painter top-left)
                (below bottom-right corner))))))

(defn square-of-four [tl tr bl br]
  (fn [painter]
    (let [top (beside (tl painter) (tr painter))
          bottom (beside (bl painter) (br painter))]
      (below top bottom))))

(defn flipped-pairs [painter]
  (let [combine4 (square-of-four identity flip-vert
                                 flip-vert identity)]
    (combine4 painter)))

(defn square-limit [painter n]
  (let [combine4 (square-of-four flip-horiz identity
                                 rotate180 flip-vert)]
    (combine4 (corner-split painter n))))

(defn make-frame [origin edge1 edge2] (list origin edge1 edge2)) ; dummy implementation
(defn origin-frame [frame] frame) ; dummy implementation
(defn edge1-frame [frame] frame) ; dummy implementation
(defn edge2-frame [frame] frame) ; dummy implementation

(defn frame-coord-map [frame]
  (fn [v]
    (add-vect
     (origin-frame frame)
     (add-vect (scale-vect (xcor-vect v)
                           (edge1-frame frame))
               (scale-vect (ycor-vect v)
                           (edge2-frame frame))))))

(defn draw-line [p1 p2] (p1 p2)) ; dummy implementation

(defn segments->painter [segment-list]
  (fn [frame]
    (
     (fn [segment]
       (draw-line
        ((frame-coord-map frame) (start-segment segment))
        ((frame-coord-map frame) (end-segment segment))))
     segment-list)))

(defn transform-painter [painter origin corner1 corner2]
    (fn [frame]
      (let [m (frame-coord-map frame)
            new-origin (m origin)]
      (painter
       (make-frame new-origin
                   (sub-vect (m corner1) new-origin)
                   (sub-vect (m corner2) new-origin))))))

(defn flip-vert [painter]
  (transform-painter painter
                     (make-vect 0.0 1.0)
                     (make-vect 1.0 1.0)
                     (make-vect 0.0 0.0)))

(defn shrink-to-upper-right [painter]
  (transform-painter painter
                     (make-vect 0.5 0.5)
                     (make-vect 1.0 0.5)
                     (make-vect 0.5 1.0)))

(defn rotate90 [painter]
  (transform-painter painter
                     (make-vect 1.0 0.0)
                     (make-vect 1.0 1.0)
                     (make-vect 0.0 0.0)))

(defn squash-inwards [painter]
  (transform-painter painter
                     (make-vect 0.0 0.0)
                     (make-vect 0.65 0.35)
                     (make-vect 0.35 0.65)))

(defn beside [painter1 painter2]
  (let [split-point (make-vect 0.5 0.0)
        paint-left (transform-painter painter1
                                     (make-vect 0.0 0.0)
                                     split-point
                                     (make-vect 0.0 1.0))
        paint-right (transform-painter painter2
                                      split-point
                                      (make-vect 1.0 0.0)
                                      (make-vect 0.5 1.0))]
    (fn [frame]
      (paint-left frame)
      (paint-right frame))))
