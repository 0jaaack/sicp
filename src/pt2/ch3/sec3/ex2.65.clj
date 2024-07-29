(ns pt2.ch3.sec3.ex2.65
  (:require [pt2.ch3.sec3.ex2.62 :refer [union-ordered-set intersection-ordered-set]]
            [pt2.ch3.sec3.ex2.63 :refer [tree->list-1]]
            [pt2.ch3.sec3.ex2.64 :refer [list->tree]]))

(defn union-tree-set [set1 set2]
  (list->tree (union-ordered-set
               (tree->list-1 set1)
               (tree->list-1 set2))))

(defn intersection-tree-set [set1 set2]
  (list->tree (intersection-ordered-set
               (tree->list-1 set1)
               (tree->list-1 set2))))

(def tree1 (list->tree '(1 3 5 7 9)))

(def tree2 (list->tree '(2 4 5 7 10)))

(tree->list-1 (union-tree-set tree1 tree2))

(tree->list-1 (intersection-tree-set tree1 tree2))
