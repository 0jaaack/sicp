(ns pt2.ch2.sec1.ex2.23)

(defn for-each [fn items]
  (if (empty? items)
    '()
    (do
      (fn (first items))
      (for-each fn (rest items)))))

(for-each (fn [x] (newline) (println x)) '(57 321 88))
