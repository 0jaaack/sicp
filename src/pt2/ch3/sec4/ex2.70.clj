(ns pt2.ch3.sec4.ex2.70
  (:require [pt2.ch3.sec4.ex2.68 :refer [encode]]
            [pt2.ch3.sec4.ex2.69 :refer [generate-huffman-tree]]))

(def result-tree (generate-huffman-tree '((A 2) (NA 16) (BOOM 1) (SHA 3) (GET 2) (YIP 9) (JOB 2) (WAH 1))))

(encode '(GET A JOB) result-tree)
;; => (1 1 1 1 1 1 1 0 0 1 1 1 1 0)

(encode '(SHA NA NA NA NA NA NA NA NA) result-tree)
;; => (1 1 1 0 0 0 0 0 0 0 0 0)

(encode '(WAH YIP YIP YIP YIP YIP YIP YIP YIP YIP) result-tree)
;; => (1 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0)

(encode '(SHA BOOM) result-tree)
;; => (1 1 1 0 1 1 0 1 1)
