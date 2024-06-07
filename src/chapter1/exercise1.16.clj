(ns chapter1.exercise1.16)

(defn even? [n]
  (= (mod n 2) 0))

(defn fast-expt-iter [b n a]
  (cond
    (= n 0) a
    (even? n) (fast-expt-iter b (/ n 2) (* b b))
    :else (fast-expt-iter b (- n 1) (* b a))))

(defn fast-expt [b n]
  (fast-expt-iter b n 1))

(fast-expt 2 10)