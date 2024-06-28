(ns pt1.ch3.sec3.ex1.35
  (:require [pt1.ch3.sec3.main :refer [fixed-point]]))

(fixed-point (fn [x] (+ 1 (/ 1 x))) 1.0)
;; => 1.6180327868852458
