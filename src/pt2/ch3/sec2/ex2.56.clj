(ns pt2.ch3.sec2.ex2.56
  (:require [pt2.ch3.sec2.main :as main]))

(defn exponentiation? [exp]
  (and (coll? exp) (= (first exp) '**)))

(defn base [exp]
  (second exp))

(defn exponent [exp]
  (last exp))

(defn make-exponent [b e]
  (cond (main/=number? e 0) 1
        (main/=number? e 1) b
        :else (list '** b e)))

(defn deriv [exp var]
  (cond (number? exp) 0
        (main/variable? exp) (if (main/same-variable? exp var) 1 0)
        (main/sum? exp) (main/make-sum (deriv (main/addend exp) var)
                                       (deriv (main/augend exp) var))
        (main/product? exp) (main/make-sum
                             (main/make-product (main/multiplier exp)
                                                (deriv (main/multiplicand exp) var))
                             (main/make-product (deriv (main/multiplier exp) var)
                                                (main/multiplicand exp)))
        (exponentiation? exp) (main/make-product
                               (main/make-product (exponent exp)
                                                  (make-exponent (base exp) (- (exponent exp) 1)))
                               (deriv (base exp) var))
        :else (throw (Exception. "unknown expression type"))))

(deriv '(** x 3) 'x)
;; => (* 3 (** x 2))
