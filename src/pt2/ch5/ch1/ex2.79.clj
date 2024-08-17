(ns pt2.ch5.ch1.ex2.79)

(defn equ? [x y]
  (apply-generic ’equ? x y))

(defn equ-package []
  (letfn [(rat-equ? [x y]
            (= (* (numer x) (denom y))
               (* (numer y) (denom x))))
          (complex-equ? [x y]
            (and (= (real x) (real y))
                 (= (imag x) (imag y))))]
    (put 'equ? '(scheme-number scheme-number) =)
    (put 'equ? '(rational rational) rat-equ?)
    (put 'equ? '(complex complex) complex-equ?))
  'done)
