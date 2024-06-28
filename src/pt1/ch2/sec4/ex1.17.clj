(ns pt1.ch2.sec4.ex1.17)

(defn multi1 [a b]
  (if (= b 0)
    0
    (+ a (multi1 a (- b 1)))))

(defn double [n]
  (+ n n))

(defn halve [n]
  (/ n 2))

(defn even? [n]
  (= (mod n 2) 0))

(defn multi2 [a b]
  (cond
    (= b 0) 0
    (even? b) (double (multi2 a (halve b)))
    :else (+ a (multi2 a (- b 1)))))
