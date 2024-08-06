(ns pt2.ch4.ch1.main)

(make-from-real-imag (real-part z) (real-part z))

(make-from-mag-ang (magnitude z) (angle z))

(defn add-complex [z1 z2]
  (make-from-real-imag (+ (real-part z1) (real-part z2))
                       (+ (imag-part z1) (imag-part z2))))

(defn sub-complex [z1 z2]
  (make-from-real-imag (- (real-part z1) (real-part z2))
                       (- (imag-part z1) (imag-part z2))))

(defn mul-complex [z1 z2]
  (make-from-mag-ang (* (magnitude z1) (magnitude z2))
                     (+ (angle z1) (angle z2))))

(defn div-complex [z1 z2]
  (make-from-mag-ang (/ (magnitude z1) (magnitude z2))
                     (- (angle z1) (angle z2))))

;; Ben's solution

(defn real-part [z] (first z))

(defn imag-part [z] (second z))

(defn magnitude [z]
  (Math/sqrt (+ (Math/square (real-part z)) (Math/square (imag-part z)))))

(defn angle [z] (Math/atan (imag-part z) (real-part z)))

(defn make-from-real-imag [x y] (cons x y))

(defn make-from-mag-ang [r a]
  (cons (* r (Math/cos a)) (list (* r (Math/sin a)))))

;; Alyssa's solution

(defn real-part [z]
  (* (magnitude z) (Math/cos (angle z))))

(defn imag-part [z]
  (* (magnitude z) (Math/sin (angle z))))

(defn magnitude [z] (first z))

(defn angle [z] (second z))

(defn make-from-real-imag [x y]
  (cons (Math/sqrt (+ (Math/square x) (Math/square y)))
        (Math/atan y x)))

(defn make-from-mag-ang [r a] (cons r a))
