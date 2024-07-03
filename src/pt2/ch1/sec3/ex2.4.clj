(ns pt2.ch1.sec3.ex2.4)

(defn cons [x y]
  (fn [m] (m x y)))

(defn car [z]
  (z (fn [p q] p)))

(car (cons 1 2))
(car (fn [m] (m 1 2)))
((fn [m] (m 1 2)) (fn [p q] p))
((fn [p q] p) 1 2)
1

(defn cdr [z]
  (z (fn [p q] q)))

