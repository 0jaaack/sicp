(ns pt1.ch3.sec3.ex1.39)

(defn cont-frac [n d k]
  (defn cont-frac-iter [i result]
    (if (= i 0)
      result
      (cont-frac-iter (- i 1) (/ (n i) (- (d i) result)))))
  (cont-frac-iter k 0))

(defn tan-cf [x k]
  (cont-frac (fn [i] (if (= i 1) x (* x x)))
             (fn [i] (- (* 2 i) 1))
             k))
