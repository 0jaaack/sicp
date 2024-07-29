(ns pt2.ch3.sec3.ex2.63
  (:require [pt2.ch3.sec3.main :as main]))

(defn tree->list-1 [tree]
  (if (empty? tree)
    '()
    (concat (tree->list-1 (main/left-branch tree))
            (cons (main/entry tree) (tree->list-1 (main/right-branch tree))))))

(defn tree->list-2 [tree]
  (letfn [(copy-to-list [tree result-list]
            (if (empty? tree)
              result-list
              (copy-to-list (main/left-branch tree)
                            (cons (main/entry tree) (copy-to-list (main/right-branch tree) result-list)))))]
    (copy-to-list tree '())))


(def tree1 (main/make-tree
            7
            (main/make-tree 3
                            (main/make-tree 1 nil nil)
                            (main/make-tree 5 nil nil))
            (main/make-tree 9 nil
                            (main/make-tree 11 nil nil))))

(def tree2 (main/make-tree
            3
            (main/make-tree 1 nil nil)
            (main/make-tree 7
                            (main/make-tree 5 nil nil)
                            (main/make-tree 9 nil
                                            (main/make-tree 11 nil nil)))))

(def tree3 (main/make-tree
            5
            (main/make-tree 3
                            (main/make-tree 1 nil nil)
                            nil)
            (main/make-tree 9
                            (main/make-tree 7 nil nil)
                            (main/make-tree 11 nil nil))))

(tree->list-1 tree1)
;; => (1 3 5 7 9 11)

(tree->list-1 tree2)
;; => (1 3 5 7 9 11)

(tree->list-1 tree3)
;; => (1 3 5 7 9 11)

(tree->list-2 tree1)
;; => (1 3 5 7 9 11)

(tree->list-2 tree2)
;; => (1 3 5 7 9 11)

(tree->list-2 tree3)
;; => (1 3 5 7 9 11)
