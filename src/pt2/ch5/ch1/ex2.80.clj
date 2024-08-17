(ns pt2.ch5.ch1.ex2.80)

(defn =zero? [x]
  (apply-generic '=zero? x))

(defn =zero?-package []
  (letfn [(complex-=zero? [x y]
            (and (= (real x) 0)
                 (= (imag x) 0)))]
    (put 'equ? '(scheme-number scheme-number) (fn [x] (= x 0)))
    (put 'equ? '(rational rational) (fn [x] (= x 0)))
    (put 'equ? '(complex complex) complex-=zero?))
  'done)
