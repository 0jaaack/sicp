(ns pt1.ch2.sec2.main)

(defn fib [n]
  (if (< n 2)
      n
      (+ (fib (- n 1))
         (fib (- n 2)))))

(fib 10)

(defn fib-iter [a b count]
  (if (= count 0)
      b
      (fib-iter (+ a b) a (- count 1))))

(defn fib2 [n]
  (fib-iter 1 0 n))

(fib2 10)

(defn coin-values [kinds-of-coins]
  (cond
    (= kinds-of-coins 1) 1
    (= kinds-of-coins 2) 5
    (= kinds-of-coins 3) 10
    (= kinds-of-coins 4) 25
    (= kinds-of-coins 5) 50))

(defn cc [amount kinds-of-coins]
  (cond
    (= amount 0) 1
    (or (< amount 0) (= kinds-of-coins 0)) 0
    :else (+ (cc amount (- kinds-of-coins 1))
             (cc (- amount (coin-values kinds-of-coins))
                     kinds-of-coins))))

(defn count-change [amount]
  (cc amount 5))

(count-change 100)
