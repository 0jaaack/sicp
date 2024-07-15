(ns pt2.ch2.sec3.ex2.33
  (:require [pt2.ch2.sec3.main :refer [accumulate]]))

(defn map [p sequence]
  (accumulate (fn [x y] (cons (p x) y)) '() sequence))

(map (fn [x] (* x x)) '(1 2 3 4 5))
;; => (1 4 9 16 25)

(defn append [seq1 seq2]
  (accumulate cons seq2 seq1))

(append '(1 2 3) '(4 5 6))
;; => (1 2 3 4 5 6)

(defn length [sequence]
  (accumulate (fn [x y] (+ 1 y)) 0 sequence))

(length '(1 2 3 4 5))
;; => 5
