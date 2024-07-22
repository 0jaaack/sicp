(ns pt2.ch2.sec4.ex2.51
  (:require [pt2.ch2.sec4.main :refer [transform-painter rotate90 beside]]
            [pt2.ch2.sec4.ex2.46 :refer [make-vect]]
            [pt2.ch2.sec4.ex2.50 :refer [rotate270]]))

(defn below [painter1 painter2]
  (let [split-point (make-vect 0.5 0.0)
        paint-lower (transform-painter painter1
                                       (make-vect 0.0 0.0)
                                       (make-vect 0.0 1.0)
                                       split-point)
        paint-upper (transform-painter painter2
                                       split-point
                                       (make-vect 0.5 1.0)
                                       (make-vect 1.0 0.0))]
    (fn [frame]
      (paint-lower frame)
      (paint-upper frame))))

(defn below [painter1 painter2]
  (rotate90 (beside (rotate270 painter1) (rotate270 painter2))))
