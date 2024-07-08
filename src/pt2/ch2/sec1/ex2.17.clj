(ns pt2.ch2.sec1.ex2.17)

(defn last-pair [items]
  (if (empty? (rest items))
    items
    (last-pair (rest items))))

(last-pair '(1 2 3 4 5))
;; => (5)
