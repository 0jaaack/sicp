(ns pt1.ch3.sec4.ex1.45
  (:require [pt1.ch3.sec4.main :refer [average-damp]]
            [pt1.ch3.sec4.ex1.43 :refer [repeated]]
            [pt1.ch2.sec4.main :refer [expt2]]))

(defn average-damp-n [f n]
  (repeated (average-damp f) n))


(defn fixed-point [f first-guess damp-number]
  (def tolerance 0.00001)
  (defn close-enough? [v1 v2] (< (Math/abs (- v1 v2)) tolerance))
  (defn fixed-point-iter [guess]
    (let [next ((average-damp-n f damp-number) guess)]
      (if (close-enough? guess next)
        next
        (fixed-point-iter next))))
  (fixed-point-iter first-guess))

(defn nth-root [n]
  (def damp-number (Math/floor (Math/log n 2)))
  (defn f [x] (fn [y] (/ x (expt2 y (- n 1)))))
  (fn [x] (fixed-point (f x) 1.0 damp-number)))
