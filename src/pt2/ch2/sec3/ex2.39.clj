(ns pt2.ch2.sec3.ex2.39
  (:require [pt2.ch2.sec3.ex2.38 :refer [fold-right fold-left]]))

(defn reverse [sequence]
  (fold-right (fn [x y] (concat y (list x))) '() sequence))

(reverse '(1 2 3))
;; => (3 2 1)

(defn reverse [sequence]
  (fold-left (fn [x y] (cons y x)) '() sequence))

(reverse '(3 2 1))
;; => (1 2 3)
