(ns pt2.ch2.sec1.ex2.18)

(defn reverse [items]
  (defn reverse-iter [a items]
    (if (empty? items)
      a
      (reverse-iter (cons (first items) a) (rest items))))
  (reverse-iter '() items))
