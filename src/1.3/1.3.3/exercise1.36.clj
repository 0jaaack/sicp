(ns 1.3.1.3.3.exercise1.36
  (:require [clojure.math :as math]))

(def tolerance 0.00001)

(defn fixed-point [f first-guess]
  (defn close-enough? [x y]
    (< (Math/abs (- x y)) tolerance))
  (defn try [guess]
    (let [next (f guess)]
      (prn guess)
      (newline)
      (if (close-enough? guess next)
        next
        (recur next))))
  (try first-guess))

(fixed-point (fn [x] (/ (math/log 1000) (math/log x))) 2.0)