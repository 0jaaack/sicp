(ns pt1.ch3.sec3.ex1.38
  (:require [pt1.ch3.sec3.ex1.37 :refer [cont-frac]]))

(defn e []
  (+ 2 (cont-frac (fn [] 1.0)
                  (fn [i] (if (= (mod i 3) 2)
                       (* (/ (i + 1) 3) 2)
                       1))
                  1000)))
