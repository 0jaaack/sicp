(ns pt2.ch2.sec1.ex2.21
  (:require [pt2.ch2.sec1.main :refer [map]]))

(defn square-list [items]
  (if (empty? items)
    '()
    (cons (* (first items) (first items)) (square-list (rest items)))))

(defn square-list [items]
  (map (fn [x] (* x x)) items))
