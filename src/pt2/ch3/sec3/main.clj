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

(defn entry [tree]
  (first tree))

(defn left-branch [tree]
  (second tree))

(defn right-branch [tree]
  (last tree))

(defn make-tree [entry left right]
  (list entry left right))

(defn element-of-tree-set? [x set]
  (cond (nil? set) false
        (= x (entry set)) true
        (< x (entry set)) (element-of-tree-set? x (left-branch set))
        :else (element-of-tree-set? x (right-branch set))))

(defn adjoin-tree-set [x set]
  (cond (nil? set) (make-tree x nil nil)
        (= x (entry set)) set
        (< x (entry set)) (make-tree (entry set) (adjoin-tree-set x (left-branch set)) (right-branch set))
        :else (make-tree (entry set) (left-branch set) (adjoin-tree-set x (right-branch set)))))

(defn lookup [given-key set-of-records]
  (cond (empty? set-of-records) false
        (= given-key (key (first set-of-records)))
        (first set-of-records)
        :else (lookup given-key (rest set-of-records))))
