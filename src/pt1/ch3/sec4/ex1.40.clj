(ns pt1.ch3.sec4.ex1.40
  (:require [pt1.ch3.sec4.main :refer [newtons-method]]))

(defn cubic [a b c]
  (fn [x] (+ (* x x x) (* a x x) (* b x) c)))

(defn f [a b c]
  (newtons-method (cubic a b c) 1))
