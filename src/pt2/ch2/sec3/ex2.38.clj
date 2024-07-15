(ns pt2.ch2.sec3.ex2.38
  (:require [pt2.ch2.sec3.main :refer [accumulate]]))

(defn fold-right [op initial sequence]
  (accumulate op initial sequence))

(defn fold-left [op initial sequence]
  (defn iter [result left]
    (if (empty? left)
      result
      (iter (op result (first left)) (rest left))))
  (iter initial sequence))

(fold-right / 1 '(1 2 3))
;; => 1.5 (3/2)

(fold-left / 1 '(1 2 3))
;; => 0.16666666666666666 (1/6)

(fold-right list '() '(1 2 3))
;; => (1 (2 (3 ())))

(fold-left list '() '(1 2 3))
;; => (((() 1) 2) 3)
