(ns pt2.ch2.sec2.ex2.25)

(def a '(1 2 (5 7) 9))
(first (rest (first (rest (rest a)))))
;; => 7

(def b '((7)))
(first (first b))
;; => 7

(def c '(1 (2 (3 (4 (5 (6 7)))))))
(first (rest (first (rest (first (rest (first (rest (first (rest (first (rest c))))))))))))
;; => 7
