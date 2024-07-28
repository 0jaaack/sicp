(ns pt2.ch3.sec3.ex2.59
  (:require [pt2.ch3.sec3.main :as main]))

(defn union-set [set1 set2]
  (cond (empty? set1) set2
        (empty? set2) set1
        (main/element-of-set? (first set1) set2) (union-set (rest set1) set2)
        :else (cons (first set1) (union-set (rest set1) set2))))

(union-set '(1 2 3) '(2 3 4))
;; => (1 2 3 4)
