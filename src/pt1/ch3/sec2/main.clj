(ns pt1.ch3.sec2.main)

(fn [x] (+ x 4))

(fn [x] (/ 1.0 (* x (+ x 2))))


(defn sum [term a next b]
  (if (> a b)
    0
    (+ (term a) (sum term (next a) next b))))

(defn pi-sum [a b]
  (sum (fn [x] (/ 1.0 (* x (+ x 2))))
       a
       (fn [x] (+ x 4))
       b))

(defn f [x y]
  (defn f-helper [a b]
    (+ (* x (* a a))
       (* y b)
       (* a b)))
  (f-helper (+ 1 (* x y))
            (- 1 y)))

(defn f2 [x y]
  (fn [a b]
    (+ (* x (* a a))
       (* y b)
       (* a b)))
  (+ 1 (* x y))
  (- 1 y))

(defn f3 [x y]
  (let [a (+ 1 (* x y))
        b (- 1 y)]
    (+ (* x (* a a))
       (* y b)
       (* a b))))

(let [x 5]
  (+ (let [x 3]
       (+ x (* x 10)))
     x))

(let [x 2]
  (let [x 3
        y (+ x 2)]
    (* x y)))
