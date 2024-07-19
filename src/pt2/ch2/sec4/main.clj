(ns pt2.ch2.sec4.main
  (:require [pt2.ch2.sec4.ex2.44 :refer [up-split]]))

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
