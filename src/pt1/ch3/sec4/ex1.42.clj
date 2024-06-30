(ns pt1.ch3.sec4.ex1.42)

(defn compose [f g]
  (fn [x] (f (g x))))

(defn square [x] (* x x))

((compose square inc) 6)
