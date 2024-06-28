(ns pt1.ch2.sec1.main)

(defn factorial1 [n]
  (if (= n 1)
      1
      (* n (factorial1 (- n 1)))))

(factorial1 5)

(defn fact-iter [product counter max-count]
    (if (> counter max-count)
        product
        (fact-iter (* counter product)
                   (+ counter 1)
                   max-count)))

(defn factorial2 [n]
  (fact-iter 1 1 n))

(factorial2 5)
