(ns chapter1.exercise1.18)

(defn double [n]
  (+ n n))

(defn halve [n]
  (/ n 2))

(defn even? [n]
  (= (mod n 2) 0))

(defn multi3-iter [a b c]
  (cond
    (= b 1) (+ a c)
    (even? b) (multi3-iter a (halve b) (+ b c))
    :else (multi3-iter a (- b 1) (+ a c))))

(defn multi3 [a b]
  (multi3-iter a b 0))