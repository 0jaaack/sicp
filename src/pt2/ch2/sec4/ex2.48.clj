(ns pt2.ch2.sec4.ex2.48)

(defn make-segment [start end]
  (list start end))

(defn start-segment [segment]
  (first segment))

(defn end-segment [segment]
  (last segment))
