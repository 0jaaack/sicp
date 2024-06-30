(ns pt1.ch3.sec4.ex1.41)

(defn double [f]
  (fn [x] (f (f x))))

(((double (double double)) inc) 5)
; => 21
