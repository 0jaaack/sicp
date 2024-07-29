(ns pt2.ch3.sec3.ex2.64
  (:require [pt2.ch3.sec3.main :as main]))

(defn partial-tree [elts n]
  (if (= n 0)
    (cons '() elts)
    (let [left-size (quot (- n 1) 2)
          left-result (partial-tree elts left-size)
          left-tree (first left-result)
          non-left-elts (rest left-result)
          right-size (- n (+ 1 left-size))
          this-entry (first non-left-elts)
          right-result (partial-tree (rest non-left-elts) right-size)
          right-tree (first right-result)
          remaining-elts (rest right-result)]
      (cons (main/make-tree this-entry left-tree right-tree) remaining-elts))))

(defn list->tree [elements]
  (first (partial-tree elements (count elements))))

(list->tree '(1 3 5 7 9 11))
;; => (5 (1 () (3 () ())) (9 (7 () ()) (11 () ())))
;;     5
;;   /   \
;;  1    9
;;   \  / \
;;   3 7  11
