(ns pt2.ch2.sec3.ex2.34
  (:require [pt2.ch2.sec3.main :refer [accumulate]]))

(defn horner-eval [x coefficient-sequence]
  (accumulate (fn [this-coeff higher-terms] (+ this-coeff (* x higher-terms)))
              0
              coefficient-sequence))

(horner-eval 2 '(1 3 0 5 0 1))
;; => 79
