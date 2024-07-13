(ns pt2.ch2.sec2.main)

(def x (cons '(1 2) '(3 4)))
;; => ((1 2) 3 4)

(count x)
;; => 3

(defn count-leaves [x]
  (cond
    (nil? x) 0
    (not (coll? x)) 1
    :else (+ (count-leaves (first x))
             (count-leaves (rest x)))))

(count-leaves x)
;; => 4

(defn scale-tree [tree factor]
  (cond (and (coll? tree) (empty? tree)) '()
        (not (coll? tree)) (* tree factor)
        :else (cons (scale-tree (first tree) factor)
                    (scale-tree (rest tree) factor))))

(scale-tree '(1 (2 (3 4) 5) (6 7))
            10)

(defn scale-tree [tree factor]
  (map (fn [sub-tree]
         (if (coll? sub-tree)
           (scale-tree sub-tree factor)
           (* sub-tree factor)))
       tree))

(scale-tree '(1 (2 (3 4) 5) (6 7))
            10)
