(ns pt2.ch2.sec4.ex2.45)

(defn beside [painter1 painter2] painter1) ; dummy implementation
(defn below [painter1 painter2] painter1) ; dummy implementation

(defn split [d1 d2]
  (fn [painter n]
    (if (= n 0)
      painter
      (let [smaller ((split d1 d2) painter (- n 1))]
        (d1 painter (d2 smaller smaller))))))

(defn right-split [painter n]
  ((split beside below) painter n))

(defn up-split [painter n]
  ((split below beside) painter n))
