(defn accumulate [combiner null-value term a next b]
  (defn iter [a result]
    (if (> a b)
      result
      (iter (next a) (combiner (term a) result))))
  (iter a null-value))

(defn sum [term a next b]
  (accumulate + 0 term a next b))

(defn product [term a next b]
  (accumulate * 1 term a next b))

(defn accumulate-recur [combiner null-value term a next b]
  (if (> a b)
    null-value
    (combiner (term a) (accumulate-recur combiner null-value term (next a) next b))))