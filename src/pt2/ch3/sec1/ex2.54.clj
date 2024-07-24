(ns pt2.ch3.sec1.ex2.54)

(defn equal? [list1 list2]
  (cond
    (and (empty? list1) (empty? list2)) true
    (= (first list1) (first list2)) (equal? (rest list1) (rest list2))
    :else false))

(equal? '(this is a list) '(this is a list)) ;; => true

(equal? '(this is a list) '(this (is a) list)) ;; => false
