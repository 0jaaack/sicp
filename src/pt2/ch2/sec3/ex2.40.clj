(ns pt2.ch2.sec3.ex2.40
  (:require [pt2.ch2.sec3.main :refer [flatmap enumerate-interval]]))

(defn unique-pairs [n]
  (flatmap (fn [i]
             (map (fn [j] (i j))
                  (enumerate-interval 1 (- i 1))))
           (enumerate-interval 1 n)))
