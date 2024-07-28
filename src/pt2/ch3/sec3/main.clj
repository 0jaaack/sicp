(ns pt2.ch3.sec3.main)

(defn element-of-set? [x set]
  (cond (empty? set) false
        (= x (first set)) true
        :else (element-of-set? x (rest set))))

(defn adjoin-set [x set]
  (if (element-of-set? x set)
    set
    (cons x set)))

(defn intersection-set [set1 set2]
  (cond (or (empty? set1) (empty? set2)) '()
        (element-of-set? (first set1) set2)
        (cons (first set1) (intersection-set (rest set1) set2))
        :else (intersection-set (rest set1) set2)))

(defn element-of-ordered-set? [x set]
  (cond (empty? set) false
        (= x (first set)) true
        (< x (first set)) false
        :else (element-of-set? x (rest set))))

(defn intersection-ordered-set [set1 set2]
  (if (or (empty? set1) (empty? set2)) '()
      (let [x1 (first set1)
            x2 (first set2)]
        (cond
          (< x1 x2) (intersection-ordered-set (rest set1) set2)
          (< x2 x1) (intersection-ordered-set set1 (rest set2))
          :else (cons x1 (intersection-ordered-set (rest set1) (rest set2)))))))
