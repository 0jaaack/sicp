(ns pt2.ch1.sec3.main)

(defn cons [x y]
  (defn dispatch [m]
    (cond (= m 0) x
          (= m 1) y
          :else (throw (IllegalArgumentException. "Argument not 0 or 1"))))
  dispatch)

(defn car [z] (z 0))

(defn cdr [z] (z 1))
