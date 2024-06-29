(ns pt1.ch3.sec3.ex1.37)

(defn cont-frac [n d k]
  (defn cont-frac-iter [k result]
    (if (= k 0)
      result
      (cont-frac-iter (- k 1) (/ (n k) (+ (d k) result)))))
  (cont-frac-iter k 0))

(cont-frac (fn [] 1.0) (fn [] 1.0) 1)

(cont-frac (fn [] 1.0) (fn [] 1.0) 10)

(defn cont-frac [n d k]
  (defn cont-frac-recur [i]
    (if (= i k)
      (/ (n i) (d i))
      (/ (n i) (+ (d i) (cont-frac-recur (+ i 1))))))
  (cont-frac-recur 1))
