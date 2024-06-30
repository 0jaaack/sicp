(ns pt1.ch3.sec4.ex1.44
  (:require [pt1.ch3.sec4.ex1.43 :refer [repeated]]))

(defn smooth [f]
  (fn [x dx] (/ (+ (f (- x dx)) (f x) (f (+ x dx))) 3)))

(defn n-fold-smooth [f n]
  ((repeated smooth n) f))
