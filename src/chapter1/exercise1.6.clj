(ns chapter1.exercise1.6)

(defn new-if [predicate then-clause else-clause]
  (cond predicate then-clause :else else-clause))

(defn square [x] (* x x))

(defn good-enough? [guess x]
  (< (Math/abs (- (square guess) x)) 0.001))

(defn average [x y]
  (/ (+ x y) 2))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn sqrt-iter [guess x]
  (new-if (good-enough? guess x)
          guess
          (sqrt-iter (improve guess x) x)))
