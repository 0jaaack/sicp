(ns chapter1.exercise8)

(defn square [x]
  (* x x))

(defn improve [guess x]
  (/
   (+ (/ x (square guess))
      (* 2 guess))
   3))

(defn cube [x]
  (* x x x))

(defn good-enough? [guess x]
  (< (Math/abs (- (cube guess) x)) 0.001))

(defn third-sqrt-iter [guess x]
  (if (good-enough? guess x)
    guess
    (third-sqrt-iter (improve guess x) x)))

(defn third-sqrt [x]
  (third-sqrt-iter 1 x))

(third-sqrt 27)