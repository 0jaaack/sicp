(ns pt2.ch1.sec4.ex2.11
  (:require [pt2.ch1.sec4.ex2.7 :refer [make-interval lower-bound upper-bound]]))

(defn neg-interval? [x]
  (and (pos-int? (upper-bound x)) (pos-int? (lower-bound x))))

(defn pos-interval? [x]
  (and (neg-int? (upper-bound x)) (neg-int? (lower-bound x))))

(defn appo-interval? [x]
  (and (pos-int? (upper-bound x)) (neg-int? (lower-bound x))))

(defn mul-interval [x y]
  (cond
    (and (neg-interval? x) (neg-interval? y))
      (make-interval (* (upper-bound x) (upper-bound y))
                     (* (lower-bound x) (lower-bound y)))
    (and (neg-interval? x) (pos-interval? y))
      (make-interval (* (lower-bound x) (upper-bound y))
                     (* (upper-bound x) (lower-bound y)))
    (and (neg-interval? x) (appo-interval? y))
      (make-interval (* (lower-bound x) (upper-bound y))
                     (* (lower-bound x) (lower-bound y)))
    (and (pos-interval? x) (neg-interval? y))
      (make-interval (* (upper-bound x) (lower-bound y))
                     (* (lower-bound x) (upper-bound y)))
    (and (pos-interval? x) (pos-interval? y))
      (make-interval (* (upper-bound x) (upper-bound y))
                     (* (lower-bound x) (lower-bound y)))
    (and (pos-interval? x) (appo-interval? y))
      (make-interval (* (upper-bound x) (lower-bound y))
                     (* (upper-bound x) (upper-bound y)))
    (and (appo-interval? x) (neg-interval? y))
      (make-interval (* (upper-bound x) (lower-bound y))
                     (* (lower-bound x) (upper-bound y)))
    (and (appo-interval? x) (pos-interval? y))
      (make-interval (* (lower-bound x) (upper-bound y))
                     (* (upper-bound x) (upper-bound y)))
    (and (appo-interval? x) (appo-interval? y))
      (make-interval (Math/min (* (upper-bound x) (lower-bound y))
                               (* (lower-bound x) (upper-bound y)))
                     (Math/max (* (upper-bound x) (upper-bound y))
                               (* (lower-bound x) (lower-bound y))))))
