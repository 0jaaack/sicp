(ns pt2.ch1.sec2.main
  (:require [pt1.ch2.sec5.main :refer [gcd]]))

(defn make-rat [n d]
  [n d])

(defn number [x]
  (let [g (gcd (first x) (second x))]
    (/ (first x) g)))

(defn denom [x]
  (let [g (gcd (first x) (second x))]
    (/ (second x) g)))
