(ns pt1.ch3.sec4.main
  (:require [pt1.ch3.sec3.main :refer [fixed-point]])
  (:require [pt1.ch3.sec3.main :refer [average]]))

(defn average-damp [f]
  (fn [x] (average x (f x))))

((average-damp (fn [x] (* x x))) 10)

(defn sqrt [x]
  (fixed-point (average-damp (fn [y] (/ x y)))
               1.0))

(defn cube-root [x]
  (fixed-point (average-damp (fn [y] (/ x (* y y))))
               1.0))

(def dx 0.00001)

(defn deriv [g]
  (fn [x] (/ (- ((g (+ x dx)) (g x)) dx))))

((deriv (fn [x] (* x x x))) 5)

(defn newton-transform [g]
  (fn [x] (- x (/ ((g x) ((deriv g) x))))))

(defn newtons-method [g guess]
  (fixed-point (newton-transform g) guess))

(defn sqrt [x]
  (newtons-method (fn [y] (- (* y y) x))
                  1.0))

(defn fixed-point-of-transform [g transform guess]
  (fixed-point (transform g) guess))

(defn sqrt [x]
  (fixed-point-of-transform (fn [y] (/ x y))
                            average-damp
                            1.0))

(defn sqrt [x]
  (fixed-point-of-transform (fn [y] (- (* y y) x))
                            newton-transform
                            1.0))
