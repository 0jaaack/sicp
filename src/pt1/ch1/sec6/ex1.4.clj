(ns pt1.ch1.sec6.ex1.4)

(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))

(defn main []
  (println (a-plus-abs-b 3 4)))
