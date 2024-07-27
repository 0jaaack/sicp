(ns pt2.ch3.sec2.ex2.58)

(defn variable? [x]
  (symbol? x))

(defn same-variable? [v1 v2]
  (and (variable? v1) (variable? v2) (= v1 v2)))

(defn sum? [x]
  (letfn [(sum?-iter [x]
            (cond (empty? (rest x)) false
                  (= (second x) '+) true
                  :else (sum?-iter (rest x))))]
    (sum?-iter x)))

(defn augend [s]
  (letfn [(addend-iter [s result]
            (cond (= (first s) '+) (if (nil? (second result))
                                     (first result)
                                     result)
                  :else (addend-iter
                         (rest (rest s))
                         (concat result (list (first s) (second s))))))]
    (addend-iter (rest s) (list (first s)))))

(defn addend [s]
  (letfn [(augend-iter [s]
            (cond (= (first s) '+)
                  (if (nil? (second (rest s)))
                    (second s)
                    (rest s))
                  :else (augend-iter (rest (rest s)))))]
    (augend-iter (rest s))))

(defn =number? [exp num]
  (and (number? exp) (= exp num)))

(defn make-sum [a1 a2]
  (cond (=number? a1 0) a2
        (=number? a2 0) a1
        (and (number? a1) (number? a2)) (+ a1 a2)
        :else (list a1 '+ a2)))

(defn product? [e]
  (and (coll? e) (= (second e) '*)))

(defn multiplicand [e]
  (first e))

(defn multiplier [e]
  (if (nil? (second (rest (rest e))))
    (last e)
    (rest (rest e))))

(defn make-product [m1 m2]
  (cond (or (=number? m1 0) (=number? m2 0)) 0
        (=number? m1 1) m2
        (=number? m2 1) m1
        (and (number? m1) (number? m2)) (* m1 m2)
        :else (list m1 '* m2)))

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

(deriv '(x + (3 * (x + (y + 2)))) 'x)
;; => 4

(deriv '(x + 3 * (x + y + 2)) 'x)
;; => 4
