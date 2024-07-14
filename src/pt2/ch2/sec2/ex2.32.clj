(ns pt2.ch2.sec2.ex2.32)

(defn subsets [s]
  (cond (empty? s) '()
        (= (count s) 1) (list '() (list (first s)))
        :else (let [rest (subsets (rest s))]
                (concat rest (map (fn [x] (cons (first s) x)) rest)))))

(subsets '(1 2 3))
;; => (() (3) (2) (2 3) (1) (1 3) (1 2) (1 2 3))
