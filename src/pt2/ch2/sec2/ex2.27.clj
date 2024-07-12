(ns pt2.ch2.sec2.ex2.27)

(def x '((1 2) (3 4)))

x
;; => ((1 2) (3 4))

(reverse x)
;; => ((3 4) (1 2))

(defn deep-reverse [items]
  (defn deep-reverse-iter [result items]
    (if (empty? items)
      result
      (let [first (if (coll? (first items))
                     (deep-reverse (first items))
                     (first items))]
        (deep-reverse-iter (cons first result) (rest items)))))
  (deep-reverse-iter '() items))

(deep-reverse x)
;; => ((4 3) (2 1))
