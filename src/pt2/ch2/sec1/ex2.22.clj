(ns pt2.ch2.sec1.ex2.22)

(defn square-list [items]
  (defn iter [things answer]
    (if (empty? things)
      answer
      (iter (rest things) (cons (* (first things) (first things)) answer))))
  (iter items '()))

(square-list '(1 2 3 4 5))
;; => (25 16 9 4 1)

(defn square-list [items]
  (defn iter [things answer]
    (if (empty? things)
      answer
      (iter (rest things) (cons answer (list (* (first things) (first things)))))))
  (iter items '()))

(square-list '(1 2 3 4 5))
;; => (((((() 1) 4) 9) 16) 25)

(defn square-list [items]
  (defn iter [things answer]
    (if (empty? things)
      answer
      (cons (* (first things) (first things)) (iter (rest things) answer))))
  (iter items '()))
;; => (1 4 9 16 25)
