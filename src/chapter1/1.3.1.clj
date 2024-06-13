(ns chapter1.1.3.1)

(defn cube [x] (* x x x))

(defn sum-integers [a b]
  (if (> a b)
    0
    (+ a (sum-integers (+ a 1) b))))

(defn sum-cubes [a b]
  (if (> a b)
    0
    (+ (cube a) (sum-cubes (+ a 1) b))))

(defn pi-sum [a b]
  (if (> a b)
    0
    (+ (/ 1.0 (* a (+ a 2))) (pi-sum (+ a 4) b))))

(defn sum [term a next b]
  (if (> a b)
    0
    (+ (term a) (sum term (next a) next b))))

(defn inc [n] (+ n 1))

(defn sum-cubes [a b]
  (sum cube a inc b))

(defn sum-integers [a b]
  (sum identity a inc b))

(defn pi-sum [a b]
  (sum (fn [x] (/ 1.0 (* x (+ x 2)))) a (fn [x] (x + 4)) b))

(defn integral [f a b dx]
  (* (sum f (+ a (/ dx 2.0)) (fn [x] (+ x dx)) b) dx))

