(ns pt2.ch2.sec2.ex2.30)

(defn square-tree [tree]
  (cond
    (and (coll? tree) (empty? tree)) '()
    (not (coll? tree)) (* tree tree)
    :else (cons (square-tree (first tree))
                (square-tree (rest tree)))))

(square-tree '(1 (2 (3 4) 5) (6 7)))
;; => (1 (4 (9 16) 25) (36 49))

(defn square-tree [tree]
  (map (fn [sub-tree]
         (if (coll? sub-tree)
           (square-tree sub-tree)
           (* sub-tree sub-tree)))
       tree))

(square-tree '(1 (2 (3 4) 5) (6 7)))
;; => (1 (4 (9 16) 25) (36 49))
