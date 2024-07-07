(ns pt2.ch1.sec4.ex2.12
  (:require [pt2.ch1.sec4.ex2.7 :refer [make-interval]]))

(defn make-center-percent [c p]
  (let [w (* c p)]
    (make-interval (- c w) (+ c w))))
