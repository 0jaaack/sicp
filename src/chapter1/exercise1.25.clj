(ns chapter1.exercise1.25
  (:require [chapter1.1.2.4 :refer [fast-expt]]))

(defn expmod [base exp m]
  (mod (fast-expt base exp) m))

(defn fermat-test [n]
  (defn try-it [a]
    (= (expmod a n n) a))
  (try-it (+ 1 (rand-int (- n 1)))))

(defn fast-prime? [n times]
  (cond
    (= times 0) true
    (fermat-test n) (fast-prime? n (- times 1))
    :else false))

