(ns pt1.ch3.sec4.ex1.46)

(defn iterative-improve [good-enough? improve]
  (defn iterative-improve-iter [guess]
    (if (good-enough? guess)
      guess
      (iterative-improve-iter (improve guess))))
  (fn [x] (iterative-improve-iter x)))

(defn sqrt [x]
  ((iterative-improve (fn [d] (< (Math/abs (- (* d d) x)) 0.001))
                      (fn [d]  (/ (+ d (/ x d)) 2)))
   1.0))

(defn fixed-point [f]
  (iterative-improve (fn [guess] (< (Math/abs (- (f guess) guess)) 0.001)) f))
