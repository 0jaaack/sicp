(ns pt2.ch2.sec3.ex2.42
  (:require [pt2.ch2.sec3.main :refer [flatmap enumerate-interval]]))

(defn position [x y] (list x y))

(defn x-position [position]
  (first position))

(defn y-position [position]
  (second position))

(defn adjoin-position [y x rest-of-queens]
  (print y x rest-of-queens)
  (cons (position x y) rest-of-queens))

(def empty-board '())

(defn safe? [k rest-of-queens]
  (print k rest-of-queens)
  (let [new-position (first rest-of-queens)]
    (every? (fn [position]
              (and (not (= (y-position position) (y-position new-position)))
                   (not (= (Math/abs (- (x-position position) (x-position new-position)))
                           (Math/abs (- (y-position position) (y-position new-position)))))))
            (rest rest-of-queens))))

(defn queens [board-size]
  (defn queen-cols [k]
    (if (= k 0)
      (list empty-board)
      (filter
       (fn [positions] (safe? k positions))
       (flatmap
        (fn [rest-of-queens]
          (map (fn [new-row]
                 (adjoin-position new-row k rest-of-queens))
               (enumerate-interval 1 board-size)))
        (queen-cols (- k 1))))))
  (queen-cols board-size))

(queens 5)

;; (((5 4) (4 2) (3 5) (2 3) (1 1))
;; ((5 3) (4 5) (3 2) (2 4) (1 1))
;; ((5 5) (4 3) (3 1) (2 4) (1 2))
;; ((5 4) (4 1) (3 3) (2 5) (1 2))
;; ((5 5) (4 2) (3 4) (2 1) (1 3))
;; ((5 1) (4 4) (3 2) (2 5) (1 3))
;; ((5 2) (4 5) (3 3) (2 1) (1 4))
;; ((5 1) (4 3) (3 5) (2 2) (1 4))
;; ((5 3) (4 1) (3 4) (2 2) (1 5))
;; ((5 2) (4 4) (3 1) (2 3) (1 5)))
