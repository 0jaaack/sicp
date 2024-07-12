(ns pt2.ch2.sec2.ex2.28)

(def x '((1 2) (3 4)))

(defn fringe [tree]
  (defn fringe-iter [result tree]
    (cond
      (empty? tree) result
      (coll? (first tree)) (concat (fringe (first tree)) (fringe-iter result (rest tree)))
      :else (cons (first tree) (fringe-iter result (rest tree)))))
  (fringe-iter '() tree))

(fringe x)
;; => (1 2 3 4)

(fringe '(((1 2) (3 4)) ((1 2) (3 4))))
;; => (1 2 3 4 1 2 3 4)
