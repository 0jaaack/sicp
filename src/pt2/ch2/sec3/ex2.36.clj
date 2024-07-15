(ns pt2.ch2.sec3.ex2.36
  (:require [pt2.ch2.sec3.main :refer [accumulate]]))

(def s '((1 2 3) (4 5 6) (7 8 9) (10 11 12)))

(defn accumulate-n [op init seqs]
  (if (empty? (first seqs))
    '()
    (cons (accumulate op init (map first seqs))
          (accumulate-n op init (map rest seqs)))))

(accumulate-n + 0 s)
;; => (22 26 30)
