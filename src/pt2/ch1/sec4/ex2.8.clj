(ns pt2.ch1.sec4.ex2.8
  (:require [pt2.ch1.sec4.ex2.7 :refer [make-interval lower-bound upper-bound]]))

(defn sub-interval [n m]
  (make-interval (- (lower-bound n) (upper-bound m))
                 (- (upper-bound n) (lower-bound m))))
