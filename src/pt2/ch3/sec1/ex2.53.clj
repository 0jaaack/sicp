(ns pt2.ch3.sec1.ex2.53
  (:require [pt2.ch3.sec1.main :refer [memq]]))

(list 'a 'b 'c) ;; => (a b c)

(list (list 'george)) ;; => ((george))

(rest '((x1 x2) (y1 y2))) ;; => ((y1 y2))

(coll? (first '(a short list))) ;; => false

(memq 'red '((red shoes) (blue socks))) ;; => false

(memq 'red '(red shoes blue socks)) ;; => (red shoes blue socks)
