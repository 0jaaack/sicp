(ns pt1.ch2.sec6.ex1.27
  (:require [pt1.ch2.sec6.main :refer [expmod]]))

(defn fermat-test [n k]
  (defn try-it [a]
    (= (expmod a n n) a))
  (try-it k))

(defn prime?-iter [n count]
  (cond
    (= count 0) true
    (fermat-test n count) (prime?-iter n (- count 1))
    :else false))

(defn prime? [n]
    (prime?-iter n (- n 1)))
