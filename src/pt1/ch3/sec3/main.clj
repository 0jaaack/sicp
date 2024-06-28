(ns pt1.ch3.sec3.main)

(defn close-enough? [x y]
  (< (Math/abs (- x y)) 0.00001))

(defn search [f neg-point pos-point]
  (let [mid-point (Math/average neg-point pos-point)]
    (if (close-enough? neg-point pos-point)
      mid-point
      (let [test-value (f mid-point)]
        (cond
          (pos? test-value) (search f neg-point mid-point)
          (neg? test-value) (search f mid-point pos-point)
          :else mid-point)))))

(defn half-interval-method [f a b]
  (let [a-value (f a)
        b-value (f b)]
    (cond
      (and (neg? a-value) (pos? b-value)) (search f a b)
      (and (neg? b-value) (pos? a-value)) (search f b a)
      :else (throw (IllegalArgumentException. "Values are not of opposite sign")))))

(half-interval-method (fn [x] (- (* x x x) (* 2 x) 3)) 2.0 4.0)

(def tolerance 0.00001)

(defn fixed-point [f first-guess]
  (defn close-enough? [x y]
    (< (Math/abs (- x y)) tolerance))
  (defn try [guess]
    (let [next (f guess)]
      (if (close-enough? guess next)
        next
        (recur next))))
  (try first-guess))

(defn sqrt [x]
  (fixed-point (fn [y] (/ x y)) 1.0))

(defn average [x y] (/ (+ x y) 2))
(defn sqrt [x]
  (fixed-point (fn [y] (average y (/ x y))) 1.0))
