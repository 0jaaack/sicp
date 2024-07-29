(ns pt2.ch3.sec3.ex2.66
  (:require [pt2.ch3.sec3.main :as main]
            [pt2.ch3.sec3.ex2.64 :refer [list->tree]]))

(defn lookup-tree [given-key set-of-records]
  (cond (nil? set-of-records) false
        (= given-key (main/entry set)) (main/entry set)
        (< given-key (main/entry set)) (lookup-tree given-key (main/left-branch set))
        :else (lookup-tree given-key (main/right-branch set))))

(lookup-tree 3 (list->tree '(1 3 5 7 9)))
;; => 3
