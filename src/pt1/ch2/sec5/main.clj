(ns pt1.ch2.sec5.main)

(defn gcd [a b]
  (if (= b 0)
    a
    (gcd b (mod a b))))
