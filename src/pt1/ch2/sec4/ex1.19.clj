(ns pt1.ch2.sec4.ex1.19)

(defn fib-iter [a b p q count]
  (cond
    (= count 0) b
    (even? count) (fib-iter a
                           b
                           (+ (* p p) (* q q))
                           (+ (* 2 p q) (* q q))
                           (/ count 2))
    :else (fib-iter (+ (* b q) (* a q) (* a p))
                    (+ (* b p) (* a q))
                    p
                    q
                    (- count 1))))

(defn fib [n]
  (fib-iter 1 0 0 1 n))

(fib 10)
