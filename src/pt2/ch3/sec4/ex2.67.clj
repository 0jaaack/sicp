(ns pt2.ch3.sec4.ex2.67
  (:require [pt2.ch3.sec4.main :as main]))

(def sample-tree
  (main/make-code-tree (main/make-leaf 'A 4)
                       (main/make-code-tree (main/make-leaf 'B 2)
                                            (main/make-code-tree (main/make-leaf 'D 1)
                                                                 (main/make-leaf 'C 1)))))
(def sample-message '(0 1 1 0 0 1 0 1 0 1 1 1 0))

(main/decode sample-message sample-tree)
;; => (A D A B B C A)
