(ns pt2.ch1.sec2.ex2.3
  (:require [pt2.ch1.sec2.ex2.2 :refer [make-segment, start-segment, end-segment, x-point, y-point, make-point]]
            [pt1.ch3.sec4.ex1.45 :refer [nth-root]]))

(defn make-square [p1 p2 p3 p4]
  [p1 p2 p3 p4])

(defn root [n]
  ((nth-root 2) n))

(defn perimeter-segment [segment]
  (let [dx (- (x-point (end-segment segment)) (x-point (start-segment segment)))
        dy (- (y-point (end-segment segment)) (y-point (start-segment segment)))]
      (root (+ (* dx dx) (* dy dy)))))

(defn n-point [square n]
  (get square n))

(defn n-segment [square n]
  (make-segment (n-point square n)
                (n-point square (if (= n 4) 1 (+ n 1)))))

(defn perimeter-square [square]
  (+ (perimeter-segment (n-segment square 1))
     (perimeter-segment (n-segment square 2))
     (perimeter-segment (n-segment square 3))
     (perimeter-segment (n-segment square 4))))

(perimeter-square (make-square (make-point 1 1)
                               (make-point 1 2)
                               (make-point 2 2)
                               (make-point 2 1)))
