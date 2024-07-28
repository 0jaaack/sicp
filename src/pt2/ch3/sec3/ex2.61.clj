(ns pt2.ch3.sec3.ex2.61)

(defn adjoin-ordered-set [x set]
  (if (empty? set)
    (list x)
    (let [y (first set)]
      (cond
        (< x y) (cons x set)
        (= x y) set
        :else (cons y (adjoin-ordered-set x (rest set)))))))

(adjoin-ordered-set 3 '(1 2 4 5))
;; => (1 2 3 4 5)

(adjoin-ordered-set 3 '(1 2 3 4 5))
;; => (1 2 3 4 5)
