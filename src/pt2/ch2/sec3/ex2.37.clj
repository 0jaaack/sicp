(ns pt2.ch2.sec3.ex2.37
  (:require [pt2.ch2.sec3.main :refer [accumulate]])
  (:require [pt2.ch2.sec3.ex2.36 :refer [accumulate-n]]))

(def m '((1 2 3 4) (4 5 6 6) (6 7 8 9)))

(defn dot-product [v w]
  (accumulate + 0 (map * v w)))

(defn matrix-*-vector [m v]
  (map (fn [x] (dot-product x v)) m))

(defn transpose [mat]
  (accumulate-n cons '() mat))

(defn matrix-*-matrix [m n]
  (let [cols (transpose n)]
    (map (fn [x] (matrix-*-vector cols x)) m)))
