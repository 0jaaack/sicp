(ns pt2.ch3.sec3.ex2.62)

(defn intersection-ordered-set [set1 set2]
  (if (or (empty? set1) (empty? set2)) '()
      (let [x1 (first set1)
            x2 (first set2)]
        (cond
          (< x1 x2) (intersection-ordered-set (rest set1) set2)
          (< x2 x1) (intersection-ordered-set set1 (rest set2))
          :else (cons x1 (intersection-ordered-set (rest set1) (rest set2)))))))

(defn union-ordered-set [set1 set2]
  (cond (empty? set1) set2
        (empty? set2) set1
        :else (let [x1 (first set1)
                    x2 (first set2)]
                (cond
                  (< x1 x2) (cons x1 (union-ordered-set (rest set1) set2))
                  (< x2 x1) (cons x2 (union-ordered-set set1 (rest set2)))
                  :else (cons x1 (union-ordered-set (rest set1) (rest set2)))))))

(union-ordered-set '(1 3 5 7 9) '(2 3 4 5 6 7))
;; => (1 2 3 4 5 6 7 9)
