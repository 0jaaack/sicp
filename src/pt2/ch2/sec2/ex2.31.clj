(ns pt2.ch2.sec2.ex2.31)

(defn tree-map [proc tree]
  (map (fn [sub-tree]
         (if (coll? sub-tree)
           (tree-map proc sub-tree)
           (proc sub-tree)))
       tree))

(defn square-tree [tree]
  (tree-map (fn [x] (* x x)) tree))

(square-tree '(1 (2 (3 4) 5) (6 7)))
;; => (1 (4 (9 16) 25) (36 49))
