(ns pt2.ch2.sec2.main)

(def x (cons '(1 2) '(3 4)))
;; => ((1 2) 3 4)

(count x)
;; => 3

(defn count-leaves [x]
  (cond
    (nil? x) 0
    (not (coll? x)) 1
    :else (+ (count-leaves (first x))
             (count-leaves (rest x)))))

(count-leaves x)
;; => 4
