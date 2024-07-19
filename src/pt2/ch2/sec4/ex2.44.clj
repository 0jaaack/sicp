(ns pt2.ch2.sec4.ex2.44)

(defn beside [painter1 painter2] painter1) ; dummy implementation
(defn below [painter1 painter2] painter1) ; dummy implementation

(defn up-split [painter n]
  (if (= n 0)
    painter
    (let [smaller (up-split painter (- n 1))]
      (below painter (beside smaller smaller)))))
