(ns pt2.ch1.sec1.main
  (:require [pt1.ch2.sec5.main :refer [gcd]]))

(defn make-rat [n d])
(defn number [x])
(defn denom [x])

(defn add-rat [x y]
  (make-rat (+ (* (number x) (denom y))
               (* (number y) (denom x)))
            (* (denom x) (denom y))))

(defn sub-rat [x y]
  (make-rat (- (* (number x) (denom y))
               (* (number y) (denom x)))
            (* (denom x) (denom y))))

(defn mul-rat [x y]
  (make-rat (* (number x) (number y))
            (* (denom x) (denom y))))

(defn div-rat [x y]
  (make-rat (* (number x) (denom y))
            (* (denom x) (number y))))

(defn equal-rat? [x y]
  (= (* (number x) (denom y))
     (* (number y) (denom x))))

(def x [1 2])

(first x)

(second x)

(def y [3 4])

(def z [x y])

(first (first z))

(first (second z))

(defn make-rat [n d] [n d])

(defn number [x] (first x))

(defn denom [x] (second x))

(defn print-rat [x]
  (newline)
  (print (number x))
  (print "/")
  (print (denom x)))

(defn new-add-rat [x y]
  (make-rat (+ (* (number x) (denom y))
               (* (number y) (denom x)))
            (* (denom x) (denom y))))

(defn new-sub-rat [x y]
  (make-rat (- (* (number x) (denom y))
               (* (number y) (denom x)))
            (* (denom x) (denom y))))

(defn new-mul-rat [x y]
  (make-rat (* (number x) (number y))
            (* (denom x) (denom y))))

(defn new-div-rat [x y]
  (make-rat (* (number x) (denom y))
            (* (denom x) (number y))))

(defn new-equal-rat? [x y]
  (= (* (number x) (denom y))
     (* (number y) (denom x))))

(def one-half (make-rat 1 2))

(print-rat one-half)
;; => 1/2

(def one-third (make-rat 1 3))

(print-rat (new-add-rat one-half one-third))
;; => 5/6

(print-rat (new-mul-rat one-half one-third))
;; => 1/6

(print-rat (new-add-rat one-third one-third))
;; => 6/9

(defn new-make-rat [n d]
  (let [g (gcd n d)]
    [(/ n g) (/ d g)]))

(defn new-new-add-rat [x y]
  (new-make-rat (+ (* (number x) (denom y))
               (* (number y) (denom x)))
            (* (denom x) (denom y))))

(print-rat (new-new-add-rat one-third one-third))
;; => 2/3
