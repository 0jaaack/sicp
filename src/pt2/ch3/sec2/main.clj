(ns pt2.ch3.sec2.main)

(defn variable? [x]
  (symbol? x))

(defn same-variable? [v1 v2]
  (and (variable? v1) (variable? v2) (= v1 v2)))

(defn sum? [x]
  (and (coll? x) (= (first x) '+)))

(defn addend [e]
  (last e))

(defn augend [e]
  (second e))

(defn make-sum-prev [a1 a2]
  (list '+ a1 a2))

(defn =number? [exp num]
  (and (number? exp) (= exp num)))

(defn make-sum [a1 a2]
  (cond (=number? a1 0) a2
        (=number? a2 0) a1
        (and (number? a1) (number? a2)) (+ a1 a2)
        :else (list '+ a1 a2)))

(defn product? [e]
  (and (coll? e) (= (first e) '*)))

(defn multiplier [e]
  (last e))

(defn multiplicand [e]
  (second e))

(defn make-product-prev [m1 m2]
  (list '* m1 m2))

(defn make-product [m1 m2]
  (cond (or (=number? m1 0) (=number? m2 0)) 0
        (=number? m1 1) m2
        (=number? m2 1) m1
        (and (number? m1) (number? m2)) (* m1 m2)
        :else (list '* m1 m2)))

(defn deriv [exp var]
  (cond (number? exp) 0
        (variable? exp) (if (same-variable? exp var) 1 0)
        (sum? exp) (make-sum (deriv (addend exp) var)
                             (deriv (augend exp) var))
        (product? exp) (make-sum
                        (make-product (multiplier exp)
                                      (deriv (multiplicand exp) var))
                        (make-product (deriv (multiplier exp) var)
                                      (multiplicand exp)))
        :else (throw (Exception. "unknown expression type"))))

(deriv '(+ x 3) 'x)
;; => (+ 0 1)
;; => 1

(deriv '(* x y) 'x)
;; => (+ (* y 1) (* 0 x))
;; => y

(deriv '(* (* x y) (+ x 3)) 'x)
;; => (+ (* (+ x 3) y) (* x y))
