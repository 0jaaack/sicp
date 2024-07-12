(ns pt2.ch2.sec2.ex2.26)

(def x '(1 2 3))
(def y '(4 5 6))

(concat x y)
;; => (1 2 3 4 5 6)

(cons x y)
;; => ((1 2 3) 4 5 6)

(list x y)
;; => ((1 2 3) (4 5 6))
