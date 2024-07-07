(ns pt2.ch1.sec4.ex2.13
  (:require [pt2.ch1.sec4.ex2.12 :refer [make-center-percent]]))

(make-center-percent 3.5 1.5)
(make-center-percent 12.5 1.3)

;; c1 = 3.5, p1 = 1.5, c2 = 12.5, p2 = 1.3

;; upper:
;; (+ c1 (* c1 p1 100)) (+ c2 (* c2 p2 100))

;; lower:
;; (- c1 (* c1 p1 100)) (- c2 (* c2 p2 100))

;; center:
;; (/ (+ (lower-bound i) (upper-bound i)) 2)

;; (/ (+ (* (- c1 (* c1 p1 100)) (- c2 (* c2 p2 100)))
;;      (* (+ c1 (* c1 p1 100)) (+ c2 (* c2 p2 100))))
;;   2)

;; (+ (* c1 c2) (* 10000 c1 c2 p1 p2))

;; width:
;; (/ (- (upper-bound i) (lower-bound i)) 2)

;; (/ (- (+ c1 (* c1 p1 100)) (+ c2 (* c2 p2 100)) (- c1 (* c1 p1 100)) (- c2 (* c2 p2 100))) 2)

;; (* 100 c1 c2 (+ p1 p2))

;; percent:
;; width = center * percent / 100
;; percent = width * 100 / center
;; (/ (* (* 100 c1 c2 (+ p1 p2)) 100) (+ (* c1 c2) (* 10000 c1 c2 p1 p2)))
;; (/ (p1 + p2) (+ (/ 1 10000) (* p1 p2)))

(defn mul-interval-percent [c1 p1 c2 p2]
  (/ (p1 + p2) (+ (/ 1 10000) (* p1 p2))))
