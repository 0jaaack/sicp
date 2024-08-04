(ns pt2.ch3.sec4.ex2.69
  (:require [pt2.ch3.sec4.main :as main]
            [pt2.ch3.sec4.ex2.68 :refer [encode]]))

(defn successive-merge [set]
  (println "set" set)
  (if (empty? (second set))
    (first set)
    (let [current-node (main/make-code-tree (first set) (second set))
          rest (rest (rest set))]
      (if (empty? rest)
        current-node
        (successive-merge (main/adjoin-set current-node rest))))))

(defn generate-huffman-tree [pairs]
  (successive-merge (main/make-leaf-set pairs)))

(def result-tree (generate-huffman-tree '((A 4) (B 2) (D 1) (C 1))))
result-tree
;; => ((leaf A 4) ((leaf B 2) ((leaf C 1) (leaf D 1) (C D) 2) (B C D) 4) (A B C D) 8)

(def encoded (encode '(A D A B B C A) result-tree))
;; => (0 1 1 1 0 1 0 1 0 1 1 0 0)

(main/decode encoded result-tree)
;; => (A D A B B C A)
