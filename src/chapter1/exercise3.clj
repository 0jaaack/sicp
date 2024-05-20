(ns chapter1.exercise3)

(defn square [x] (* x x))

(defn calculate [x y z]
  (cond (and (> x z) (> y z)) (+ (square x) (square y))
        (and (> x y) (> z y)) (+ (square x) (square z))
        :else (+ (* y y) (* z z))))

(defn main []
  (println (calculate 3 4 5)))