(ns pt2.ch4.ch2.main)

(defn attach-tag [type-tag contents]
  (cons type-tag contents))

(defn type-tag [datum]
  (if (list? datum)
    (first datum)
    (throw (Exception. "Bad tagged datum -- TYPE-TAG"))))

(defn contents [datum]
  (if (list? datum)
    (rest datum)
    (throw (Exception. "Bad tagged datum -- CONTENTS"))))

(defn rectangular? [z]
  (= (type-tag z) 'rectangular))

(defn polar? [z]
  (= (type-tag z) 'polar))

;; Ben's solution

(defn real-part-rectangular [z] (first z))

(defn imag-part-rectangular [z] (second z))

(defn magnitude-rectangular [z]
  (Math/sqrt (+ (Math/square (real-part-rectangular z))
                (Math/square (imag-part-rectangular z)))))

(defn angle-rectangular [z]
  (Math/atan (imag-part-rectangular z)
             (real-part-rectangular z)))

(defn make-from-real-imag-rectangular [x y]
  (attach-tag 'rectangular (cons x y)))

(defn make-from-mag-ang-rectangular [r a]
  (attach-tag 'rectangular
              (cons (* r (Math/cos a)) (list (* r (Math/sin a))))))

;; Alyssa's solution

(defn magnitude-polar [z] (first z))

(defn angle-polar [z] (second z))

(defn real-part-polar [z]
  (* (magnitude-polar z) (Math/cos (angle-polar z))))

(defn imag-part-polar [z]
  (* (magnitude-polar z) (Math/sin (angle-polar z))))

(defn make-from-real-imag-polar [x y]
  (cons (Math/sqrt (+ (Math/square x) (Math/square y)))
        (Math/atan y x)))

(defn make-from-mag-ang-polar [r a] (cons r a))

;; generic operations

(defn real-part [z]
  (cond (rectangular? z) (real-part-rectangular (contents z))
        (polar? z) (real-part-polar (contents z))
        :else (throw (Exception. "Unknown type -- REAL-PART"))))

(defn imag-part [z]
  (cond (rectangular? z) (imag-part-rectangular (contents z))
        (polar? z) (imag-part-polar (contents z))
        :else (throw (Exception. "Unknown type -- IMAG-PART"))))

(defn magnitude [z]
  (cond (rectangular? z) (magnitude-rectangular (contents z))
        (polar? z) (magnitude-polar (contents z))
        :else (throw (Exception. "Unknown type -- MAGNITUDE"))))

(defn angle [z]
  (cond (rectangular? z) (angle-rectangular (contents z))
        (polar? z) (angle-polar (contents z))
        :else (throw (Exception. "Unknown type -- ANGLE"))))

(defn add-complex [z1 z2]
  (make-from-real-imag-rectangular (+ (real-part z1) (real-part z2))
                                   (+ (imag-part z1) (imag-part z2))))

(defn sub-complex [z1 z2]
  (make-from-real-imag-rectangular (- (real-part z1) (real-part z2))
                                   (- (imag-part z1) (imag-part z2))))

(defn mul-complex [z1 z2]
  (make-from-mag-ang-rectangular (* (magnitude z1) (magnitude z2))
                                 (+ (angle z1) (angle z2))))

(defn div-complex [z1 z2]
  (make-from-mag-ang-rectangular (/ (magnitude z1) (magnitude z2))
                                 (- (angle z1) (angle z2))))

(defn make-from-real-imag [x y]
  (make-from-real-imag-rectangular x y))

(defn make-from-mag-ang [r a]
  (make-from-mag-ang-rectangular r a))
