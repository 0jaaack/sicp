(ns pt2.ch5.ch1.ex2.78)

(defn attach-tag [type-tag contents]
  (if (number? contents)
    contents
    (cons type-tag contents)))

(defn type-tag [datum]
  (if (list? datum)
    (first datum)
    'scheme-number))

(defn contents [datum]
  (if (list? datum)
    (rest datum)
    datum))
