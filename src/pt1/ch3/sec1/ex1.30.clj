(ns pt1.ch3.sec1.ex1.30)

(defn sum [term a next b]
  (defn iter [a result]
    (if (> a b)
      result
      (iter (next a) (+ (term a) result))))
  (iter a 0))
