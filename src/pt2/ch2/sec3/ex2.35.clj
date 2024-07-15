(ns pt2.ch2.sec3.ex2.35
  (:require [pt2.ch2.sec3.main :refer [accumulate]]))

(defn count-leaves [t]
  (accumulate + 0 (map
                   (fn [subtree] (if (coll? subtree) (count-leaves subtree) 1))
                   t)))

(count-leaves '(1 (2 (3 4) 5) (6 7)))
;; => 7
