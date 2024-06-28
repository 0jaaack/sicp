(ns pt1.ch2.sec6.ex1.28)

(defn square [x] (* x x))

(defn nontrivial-test [x m]
  (if (and (not (= x 1))
           (not (= x (- m 1)))
           (= (mod (square x) m) 1))
      0
      (mod (square x) m)))

(defn expmod [base exp m]
  (cond
    ((= exp 0) 1)
    ((even? exp) (nontrivial-test (expmod base (/ exp 2) m) m))
    :else (mod (* base (expmod base (- exp 1) m)) m)))

(defn miller-rabin-test [n]
  (defn try-it [a]
    (= (expmod a (- n 1) n) 1))
  (try-it (+ 1 (Math/random (- n 1)))))

(defn prime? [n times]
  (cond ((= times 0) true)
        ((miller-rabin-test n) (prime? n (- times 1)))
        :else false))

(prime? 7 100)
(prime? 11 100)
(prime? 12 100)
(prime? 561 100)
(prime? 1105 100)
