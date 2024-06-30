(ns pt1.ch3.sec4.ex1.43
  (:require [pt1.ch3.sec4.ex1.42 :refer [compose]]))

(defn repeated [f n]
  (if (= n 1)
    f
    (compose f (repeated f (- n 1)))))

(def square (fn [x] (* x x)))

((repeated square 2) 5)
