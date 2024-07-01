(ns pt2.ch1.sec2.ex2.2)

(defn make-segment [start end]
  [start end])

(defn start-segment [segment]
  (first segment))

(defn end-segment [segment]
  (second segment))

(defn make-point [x y]
  [x y])

(defn x-point [point]
  (first point))

(defn y-point [point]
  (second point))

(defn average [x y]
  (/ (+ x y) 2))

(defn midpoint-segment [segment]
  (make-point (average (x-point (start-segment segment))
                       (x-point (end-segment segment)))
              (average (y-point (start-segment segment))
                       (y-point (end-segment segment)))))

(defn print-point [point]
  (newline)
  (print "(")
  (print (x-point point))
  (print ",")
  (print (y-point point))
  (print ")"))

(print-point (midpoint-segment (make-segment (make-point 1 2)
                                             (make-point 3 4))))
; => (2,3)
