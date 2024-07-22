(ns pt2.ch2.sec4.ex2.52
  (:require [pt2.ch2.sec4.ex2.44 :refer [up-split]]
            [pt2.ch2.sec4.main :refer [right-split square-limit beside below segments->painter]]
            [pt2.ch2.sec4.ex2.48 :refer [make-segment]]
            [pt2.ch2.sec4.ex2.46 :refer [make-vect]]))

; 1
(def wave
  (segments->painter
   (list
    (make-segment (make-vect 0.5 0) (make-vect 0 0.5))
    (make-segment (make-vect 0 0.5) (make-vect 0.5 1))
    (make-segment (make-vect 0.5 1) (make-vect 1 0.5))
    (make-segment (make-vect 1 0.5) (make-vect 0.5 0))))) ;; => diamond

; 2
(defn corner-split [painter n]
  (if (= n 0)
    painter
    (let [up (up-split painter (- n 1))
          right (right-split painter (- n 1))
          corner (corner-split painter (- n 1))]
      (beside (below painter up)
              (below right corner)))))

; 3
(defn einstein []) ; dummy implementation

(square-limit einstein 2)
