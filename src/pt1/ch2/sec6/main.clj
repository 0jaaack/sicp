(ns pt1.ch2.sec6.main)

(defn square [x] (* x x))

(defn find-divisor [n test-divisor]
  (cond
    (= (square test-divisor) n) test-divisor
    (> (square test-divisor) n) n
    :else (find-divisor n (+ test-divisor 1))))

(defn smallest-divisor [n]
  (find-divisor n 2))

(defn divides? [a b]
  (= (mod b a) 0))

(defn prime? [n]
  (= n (smallest-divisor n)))

; fermat-test

(defn expmod [base exp m]
  (cond
    (= exp 0) 1
    (even? exp) (mod (square (expmod base (/ exp 2) m)) m)
    :else (mod (* base (expmod base (- exp 1) m)) m)))

(defn fermat-test [n]
  (defn try-it [a]
    (= (expmod a n n) a))
  (try-it (+ 1 (rand-int (- n 1)))))

(defn fast-prime? [n times]
  (cond
    (= times 0) true
    (fermat-test n) (fast-prime? n (- times 1))
    :else false))
