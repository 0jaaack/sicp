(ns pt2.ch1.sec3.ex2.5)

(defn cons [x y]
  (* (Math/pow 2 x)
     (Math/pow 3 y)))

(defn divides-count [z n]
  (if (zero? (mod z n))
    (inc (divides-count (quot z n) n))
    0))

(defn car [z]
  (divides-count z 2))

(defn cdr [z]
  (divides-count z 3))
