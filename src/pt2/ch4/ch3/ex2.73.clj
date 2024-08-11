(ns pt2.ch4.ch3.ex2.73
  (:require [pt2.ch3.sec2.main :as deriv]
            [pt2.ch4.ch3.main :as main]))

(defn deriv-1 [exp var]
  (cond
    (number? exp) 0
    (deriv/variable? exp) (if (= exp var) 1 0)
    (deriv/sum? exp) (deriv/make-sum (derive (deriv/addend exp) var)
                                     (derive (deriv/augend exp) var))
    (deriv/product? exp) (deriv/make-sum (deriv/make-product (deriv/multiplier exp)
                                                             (derive (deriv/multiplicand exp) var))
                                         (deriv/make-product (derive (deriv/multiplier exp) var)
                                                             (deriv/multiplicand exp)))
    :else (throw (Exception. "unknown expression type -- DERIVE"))))

(defn deriv-2 [exp var]
  (cond (number? exp) 0
        (deriv/variable? exp) (if (deriv/same-variable? exp var) 1 0)
        :else ((get 'deriv (deriv/operator exp)) (deriv/operands exp) var)))

;; b

(defn install-deriv-package-1 []
  (letfn [(sum [exp var] (deriv/make-sum (derive (deriv/addend exp) var)
                                         (derive (deriv/augend exp) var)))
          (product [exp var] (deriv/make-sum (derive (deriv/addend exp) var)
                                             (derive (deriv/augend exp) var)))]
    (main/put 'deriv 'sum sum)
    (main/put 'deriv 'product product)
    'done))

;; c

(defn base [exp] (second exp))
(defn exponent [exp] (last exp))
(defn make-exponent [b e] (cond (deriv/=number? e 0) 1
                                (deriv/=number? e 1) b
                                :else (list '** b e)))

(defn install-deriv-package-2 []
  (letfn [(exponentiation [exp var] (deriv/make-product
                                     (deriv/make-product (exponent exp)
                                                         (make-exponent (base exp) (- (exponent exp) 1)))
                                     (deriv-2 (base exp) var)))]
    (main/put 'deriv 'exponentiation exponentiation)
    'done))

;; d

(defn install-deriv-package-3 []
  (letfn [(sum [exp var] (deriv/make-sum (derive (deriv/addend exp) var)
                                         (derive (deriv/augend exp) var)))
          (product [exp var] (deriv/make-sum (derive (deriv/addend exp) var)
                                             (derive (deriv/augend exp) var)))
          (exponentiation [exp var] (deriv/make-product
                                     (deriv/make-product (exponent exp)
                                                         (make-exponent (base exp) (- (exponent exp) 1)))
                                     (deriv-2 (base exp) var)))]
    (main/put 'sum 'deriv sum)
    (main/put 'product 'deriv product)
    (main/put 'exponentiation 'deriv exponentiation)
    'done))
