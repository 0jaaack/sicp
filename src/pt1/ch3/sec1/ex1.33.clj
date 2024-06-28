(ns pt1.ch3.sec1.ex1.33)

(defn accumulate [combiner null-value term a next b]
  (defn iter [a result]
    (if (> a b)
      result
      (iter (next a) (combiner (term a) result))))
  (iter a null-value))

;; temp
(defn prime? [n] n)

(defn filtered-accumulate [predicate combiner null-value term a next b]
  (defn term [x] (if (predicate x) (term x) null-value))
  (accumulate combiner null-value term a next b))

(defn sum-square-prime [a b]
  (defn square [x] (* x x))
  (defn next [x] (+ x 1))
  (filtered-accumulate prime? + 0 square a next b))

(defn gcd [a b]
  (if (= b 0)
    a
    (gcd b (mod a b))))

(defn sum-coprime [n]
  (defn coprime? [i] (= 1 (gcd i n)))
  (defn next [x] (+ x 1))
  (filtered-accumulate coprime? + 0 identity 1 next n))
