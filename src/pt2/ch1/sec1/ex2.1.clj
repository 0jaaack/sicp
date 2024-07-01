(ns pt2.ch1.sec1.ex2.1
  (:require [pt1.ch2.sec5.main :refer [gcd]]))

(defn make-rat [n d]
  (let [g (Math/abs (gcd n d))
        m (if (neg? d) (* -1 g) g)]
    [(/ n m) (/ d m)]))
