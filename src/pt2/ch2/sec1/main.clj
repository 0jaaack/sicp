(ns pt2.ch2.sec1.main)

(list 1 2 3 4)

'(1 2 3 4)

(def one-through-four '(1 2 3 4))

one-through-four
;; => (1 2 3 4)

(first one-through-four)
;; => 1

(rest one-through-four)
;; => (2 3 4)

(first (rest one-through-four))
;; => 2

(cons 10 one-through-four)
;; => (10 1 2 3 4)

(cons 5 one-through-four)
;; => (5 1 2 3 4)

(defn list-ref [items n]
  (if (= n 0)
    (first items)
    (list-ref (rest items) (- n 1))))

(def square '(1 4 9 16 25))

(list-ref square 3)
;; => 16

(defn length [items]
  (if (empty? items)
    0
    (+ 1 (length (rest items)))))

(def odds '(1 3 5 7))

(length odds)
;; => 4

(defn length [items]
  (defn length-iter [a count]
    (if (empty? items)
      count
      (length-iter (rest items) (+ 1 count)))
    (length-iter items 0)))

(defn append [list1 list2]
  (if (empty? list1)
    list2
    (cons (first list1) (append (rest list1) list2))))

(append odds '(9 11 13 15))
;; => (1 3 5 7 9 11 13 15)
