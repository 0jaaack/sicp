(ns chapter1.1.2.4)

(defn expt [b n]
  (if (= n 0)
    1
    (* b (expt b (- n 1)))))

(defn expt-iter [b counter product]
  (if (= counter 0)
    product
    (expt-iter b (- counter 1) (* b product))))

(defn expt2 [b n]
  (expt-iter b n 1))

(defn even? [n]
  (= (mod n 2) 0))

(defn fast-expt [b n]
  (cond
    (= n 0) 1
    (even? n) (Math/square (fast-expt b (/ n 2)) 2)
    :else (* b (fast-expt b (- n 1)))))