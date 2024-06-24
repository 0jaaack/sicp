(defn product-recur [term a next b]
  (if (> a b)
    1
    (* ((term a)
       (product-recur term (next a) next b)))))

(defn product-iter [term a next b]
  (defn iter [a result]
    (if (> a b)
      result
      (iter (next a) (* (term a) result))))
  (iter a 1))

(defn pi [n]
  (defn term [x]
    (/ (- (* x x) 1) (* x x)))
  (defn next [x] (+ x 2))
  (* (product-iter term 3 next n) 4))