(ns pt2.ch2.sec3.main
  (:require [pt1.ch2.sec2.main :refer [fib]]))

(defn sum-odd-squares [tree]
  (cond (empty? tree) 0
        (not (coll? tree)) (if (odd? tree) (* tree tree) 0)
        :else (+ (sum-odd-squares (first tree))
                 (sum-odd-squares (rest tree)))))

(defn even-fibs [n]
  (defn next [k]
    (if (> k n)
      '()
      (let [f (fib k)]
        (if (even? f)
          (cons f (next (+ k 1)))
          (next (+ k 1))))))
  (next 0))

(defn filter [predicate sequence]
  (cond (empty? sequence) '()
        (predicate (first sequence)) (cons (first sequence)
                                           (filter predicate (rest sequence)))
        :else (filter predicate (rest sequence))))

(filter odd? '(1 2 3 4 5))
;; => (1 3 5)

(defn accumulate [op initial sequence]
  (if (empty? sequence)
    initial
    (op (first sequence)
        (accumulate op initial (rest sequence)))))

(accumulate + 0 '(1 2 3 4 5))
;; => 15

(accumulate * 1 '(1 2 3 4 5))
;; => 120

(accumulate cons '() '(1 2 3 4 5))
;; => (1 2 3 4 5)

(defn enumerate-interval [low high]
  (if (> low high)
    '()
    (cons low (enumerate-interval (+ low 1) high))))

(enumerate-interval 2 7)
;; => (2 3 4 5 6 7)

(defn enumerate-tree [tree]
  (cond (and (coll? tree) (empty? tree)) '()
        (not (coll? tree)) (list tree)
        :else (concat (enumerate-tree (first tree))
                      (enumerate-tree (rest tree)))))

(enumerate-tree '(1 (2 (3 4) 5) (6 7)))
;; => (1 2 3 4 5 6 7)

(defn square [x] (* x x))

(defn sum-odd-squares [tree]
  (accumulate +
              0
              (map square
                   (filter odd?
                      (enumerate-tree tree)))))

(defn sum-odd-squares [tree]
  (->> (enumerate-tree tree)
       (filter odd?)
       (map square)
       (accumulate + 0)))

(defn even-fibs [n]
  (accumulate cons '()
              (filter even?
                      (map fib
                           (enumerate-interval 0 n)))))

(defn even-fibs [n]
  (->> (enumerate-interval 0 n)
       (map fib)
       (filter even?)
       (accumulate cons '())))

(defn list-fib-squares [n]
  (accumulate cons
              '()
              (map square
                   (map fib
                        (enumerate-interval 0 n)))))

(defn list-fib-squares [n]
  (->> (enumerate-interval 0 n)
       (map fib)
       (map square)
       (accumulate cons '())))

(list-fib-squares 10)
;; => (0 1 1 4 9 25 64 169 441 1156 3025)
