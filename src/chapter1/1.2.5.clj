(ns chapter1.1.2.5)

(defn gcd [a b]
  (if (= b 0)
    a
    (gcd b (mod a b))))

