(ns pt1.ch2.sec6.ex1.23)

(defn square [x] (* x x))

(defn next-odd [n]
  (if (= n 2)
    3
    (+ n 2)))

(defn find-divisor [n test-divisor]
  (cond
    (= (square test-divisor) n) test-divisor
    (> (square test-divisor) n) n
    :else (find-divisor n (next-odd test-divisor))))

(defn find-divisor [n test-divisor]
  (cond
    (= (square test-divisor) n) test-divisor
    (> (square test-divisor) n) n
    :else (find-divisor n (+ test-divisor 1))))

(defn smallest-divisor [n]
  (find-divisor n 2))

(defn prime? [n]
  (= n (smallest-divisor n)))

(prime? 1000)

(prime? 1000000)
