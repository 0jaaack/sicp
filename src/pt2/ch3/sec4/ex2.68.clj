(ns pt2.ch3.sec4.ex2.68
  (:require [pt2.ch3.sec4.main :as main]
            [pt2.ch3.sec4.ex2.67 :refer [sample-tree]]))

(defn have-symbol? [symbol tree]
  (letfn [(have-symbol-iter [symbol symbols]
            (cond (empty? symbols) false
                  (= symbol (first symbols)) true
                  :else (have-symbol-iter symbol (rest symbols))))]
    (have-symbol-iter symbol (main/symbols tree))))

(defn encode-symbol [symbol tree]
  (if (main/leaf? tree)
    '()
    (let [left (main/left-branch tree)
          right (main/right-branch tree)]
      (if (have-symbol? symbol left)
        (cons 0 (encode-symbol symbol left))
        (cons 1 (encode-symbol symbol right))))))

(defn encode [message tree]
  (if (empty? message)
    '()
    (concat (encode-symbol (first message) tree)
            (encode (rest message) tree))))

(encode '(A D A B B C A) sample-tree)
;; => (0 1 1 0 0 1 0 1 0 1 1 1 0)
