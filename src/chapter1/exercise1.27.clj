(ns chapter1.exercise1.27
  (:require [chapter1.1.2.6 :refer [expmod]]))

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
