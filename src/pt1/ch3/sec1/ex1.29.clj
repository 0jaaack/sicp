(ns pt1.ch3.sec1.ex1.29
  (:require [pt1.ch3.sec1.main :refer [sum]]))

(defn simpson [f a b n]
  (defn h [n] (/ (- b a) n))
  (defn y [k] (f (+ a (* k (h n)))))
  (defn next [n] (+ n 1))
  (defn simpson-term [k]
    (cond
      (or (= k 0) (= k n)) (y k)
      (even? n) (* 2 (y n))
      :else (* 4 (y n)))
  (* (/ (h n) 3)
     (sum simpson-term 0 next b))))

(defn cube [x] (* x x x))

(simpson cube 0 1 100)
(simpson cube 0 1 1000)
