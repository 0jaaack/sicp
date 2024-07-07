(ns pt2.ch1.sec4.ex2.9
  (:require [pt2.ch1.sec4.ex2.7 :refer [make-interval lower-bound upper-bound]]))

(defn width [x]
  (/ (- (upper-bound x) (lower-bound x)) 2))

(defn add-interval [x y]
  (make-interval (+ (lower-bound x) (lower-bound y))
                 (+ (upper-bound x) (upper-bound y))))
