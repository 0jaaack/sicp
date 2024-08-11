(ns pt2.ch4.ch3.ex2.75)

(defn make-from-mag-ang [x y]
  (letfn [(dispatch [op]
            (cond (= op 'magnitude) x
                  (= op 'angle) y
                  (= op 'real-part) (* x (Math/cos y))
                  (= op 'imag-part) (* x (Math/sin y))
                  :else (throw (Exception. "Unknown operation -- MAKE-FROM-MAG-ANG" op))))]
    dispatch))
