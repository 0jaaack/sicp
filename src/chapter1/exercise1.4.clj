(ns chapter1.exercise1.4)

(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))

(defn main []
  (println (a-plus-abs-b 3 4)))