(ns pt2.ch3.sec2.ex2.57
  (:require [pt2.ch3.sec2.main :as main]))

(defn augend [s]
  (second s))

(defn addend [s]
  (let [end (rest (rest s))]
    (if (= (count end) 1) (first end)
        (cons '+ end))))

(defn multiplicand [p]
  (second p))

(defn multiplier [p]
  (let [end (rest (rest p))]
    (if (= (count end) 1) (first end)
        (cons '* end))))

(defn deriv [exp var]
  (cond (number? exp) 0
        (main/variable? exp) (if (main/same-variable? exp var) 1 0)
        (main/sum? exp) (main/make-sum (deriv (addend exp) var)
                                       (deriv (augend exp) var))
        (main/product? exp) (main/make-sum
                             (main/make-product (multiplier exp)
                                                (deriv (multiplicand exp) var))
                             (main/make-product (deriv (multiplier exp) var)
                                                (multiplicand exp)))
        :else (throw (Exception. "unknown expression type"))))

(deriv '(* x y (+ x 3)) 'x)
;; => (+ (* y (+ x 3)) (* y x))
