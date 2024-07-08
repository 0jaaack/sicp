(ns pt2.ch2.sec1.ex2.20)

(defn same-party [x & y]
  (defn same-party-iter [term items result]
    (if (empty? items) result
        (if (term (first items))
          (same-party-iter term (rest items) (cons (first items) result))
          (same-party-iter term (rest items) result))))
  (let [term ((even? x) even? odd?)]
    (cons x (same-party-iter term y '()))))

(same-party 1 2 3 4 5 6 7 8 9 10)
;; => (1 3 5 7 9)

(same-party 2 3 4 5 6 7 8 9 10)
;; => (2 4 6 8 10)
