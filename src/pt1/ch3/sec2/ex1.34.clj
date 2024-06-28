(ns pt1.ch3.sec2.ex1.34)

(defn f [g]
  (g 2))

(defn square [x]
  (* x x))

(f square)

(f (fn [z] (* z (+ z 1))))

(f f)
