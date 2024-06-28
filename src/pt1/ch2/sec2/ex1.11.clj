(ns pt1.ch2.sec2.ex1.11)

(defn f [n]
  (if (< n 3)
    n
    (+ (f (- n 1))
       (* 2 (f (- n 2)))
       (* 3 (f (- n 3))))))

(f 10)

(defn f-iter [x y z count]
  (cond
    (= count 0) z
    (= count 1) y
    (= count 2) x
    :else (f-iter (+ x (* 2 y) (* 3 z)) y z (- count 1))))

(defn f2 [n]
  (f-iter 2 1 0 n))

(f2 10)
