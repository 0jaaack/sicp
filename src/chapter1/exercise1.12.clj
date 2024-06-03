(ns chapter1.exercise1.12)

(defn pascal [row col]
  (cond (= col row) 1
        (= col 0) 1
        :else (+ (pascal (- row 1) (- col 1))
                 (pascal (- row 1) col))))

(pascal 4 2)
