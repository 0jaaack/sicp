(ns pt2.ch3.sec3.ex2.60)

(defn element-of-set? [x set]
  (cond (empty? set) false
        (= x (first set)) true
        :else (element-of-set? x (rest set))))

(defn adjoin-set [x set]
  (cons x set))

(defn intersection-set [set1 set2]
  (cond (or (empty? set1) (empty? set2)) '()
        (element-of-set? (first set1) set2)
        (cons (first set1) (intersection-set (rest set1) set2))
        :else (intersection-set (rest set1) set2)))

(defn union-set [set1 set2]
  (concat set1 set2))

(intersection-set '(1 2 3) '(2 3 4))
;; => (2 3)

(union-set '(1 2 3 3) '(2 3 4))
;; => (1 2 3 4)
