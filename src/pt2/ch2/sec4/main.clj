(ns pt2.ch2.sec4.main
  (:require [pt2.ch2.sec4.ex2.44 :refer [up-split]]
            [pt2.ch2.sec4.ex2.46 :refer [add-vect scale-vect xcor-vect ycor-vect]]
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

(defn make-frame [])
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