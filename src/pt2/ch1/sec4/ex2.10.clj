(ns pt2.ch1.sec4.ex2.10
  (:require [pt2.ch1.sec4.ex2.7 :refer [make-interval lower-bound upper-bound]]))

(defn mul-interval [x y]
  (let [p1 (* (lower-bound x) (lower-bound y))
        p2 (* (lower-bound x) (upper-bound y))
        p3 (* (upper-bound x) (lower-bound y))
        p4 (* (upper-bound x) (upper-bound y))]
    (make-interval (min p1 p2 p3 p4)
                   (max p1 p2 p3 p4))))

(defn div-interval [x y]
  (if (or (= x 0) (= y 0))
    (throw (IllegalArgumentException. "Interval can't contains 0"))
    (mul-interval x
                  (make-interval (/ 1.0 (upper-bound y))
                                 (/ 1.0 (lower-bound y))))))


