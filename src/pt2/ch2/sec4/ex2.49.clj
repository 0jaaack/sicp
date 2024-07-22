(ns pt2.ch2.sec4.ex2.49
  (:require [pt2.ch2.sec4.main :refer [segments->painter]]
            [pt2.ch2.sec4.ex2.48 :refer [make-segment]]
            [pt2.ch2.sec4.ex2.46 :refer [make-vect]]))

(def border
  (segments->painter
   (list
    (make-segment (make-vect 0 0) (make-vect 0 1))
    (make-segment (make-vect 0 1) (make-vect 1 1))
    (make-segment (make-vect 1 1) (make-vect 1 0))
    (make-segment (make-vect 1 0) (make-vect 0 0)))))

(def x
  (segments->painter
   (list
    (make-segment (make-vect 0 0) (make-vect 1 1))
    (make-segment (make-vect 0 1) (make-vect 1 0)))))

(def diamond
  (segments->painter
   (list
    (make-segment (make-vect 0.5 0) (make-vect 0 0.5))
    (make-segment (make-vect 0 0.5) (make-vect 0.5 1))
    (make-segment (make-vect 0.5 1) (make-vect 1 0.5))
    (make-segment (make-vect 1 0.5) (make-vect 0.5 0)))))

(def wave nil) ; skip this exercise..
