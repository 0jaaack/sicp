(ns pt2.ch2.sec4.ex2.47)

(defn make-frame-1 [origin edge1 edge2]
  (list origin edge1 edge2))

(defn origin-frame-1 [frame]
  (first frame))

(defn edge1-frame-1 [frame]
  (second frame))

(defn edge2-frame-1 [frame]
  (last frame))

(defn make-frame-2 [origin edge1 edge2]
  (cons origin (cons edge1 edge2)))

(defn origin-frame-2 [frame]
  (first frame))

(defn edge1-frame-2 [frame]
  (second frame))

(defn edge2-frame-2 [frame]
  (rest (rest frame)))
