(ns pt2.ch5.ch2.main)

(defn scheme-number->complex [n]
  (make-complex-from-real-imag (contents n) 0))

(put-coercion 'scheme-number 'complex scheme-number->complex)

(defn apply-generic [op & args]
  (let [type-tags (map type-tag args)
        proc (get op type-tags)]
    (if proc
      (apply proc (map contents args))
      (if (= (count args) 2)
        (let [type1 (first type-tags)
              type2 (second type-tags)
              a1 (first args)
              a2 (second args)
              t1->t2 (get-coercion type1 type2)
              t2->t1 (get-coercion type2 type1)]
          (cond (t1->t2 (apply-generic op (t1->t2 a1) a2))
                (t2->t1 (apply-generic op a1 (t2->t1 a2)))
                :else (throw (Exception. "No method for these types"))))
        (throw (Exception. "No method for these types"))))))
