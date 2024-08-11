(ns pt2.ch4.ch3.main)

(defn put [op type item] [op type item]) ;; dummy implementation

(defn get [op type] (fn [])) ;; dummy implementation

(defn attach-tag [type-tag contents]
  (cons type-tag contents))

(defn install-rectangular-package []
  (letfn [(real-part [z] (first z))
          (imag-part [z] (second z))
          (make-from-real-imag [x y] (cons x y))
          (magnitude [z]
            (Math/sqrt (+ (Math/square (real-part z))
                          (Math/square (imag-part z)))))
          (angle [z]
            (Math/atan (imag-part z) (real-part z)))
          (make-from-mag-ang [r a]
            (cons (* r (Math/cos a)) (list (* r (Math/sin a)))))
          (tag [x] (attach-tag 'rectangular x))]
    (put 'real-part '(rectangular) real-part)
    (put 'imag-part '(rectangular) imag-part)
    (put 'magnitude '(rectangular) magnitude)
    (put 'angle '(rectangular) angle)
    (put 'make-from-real-imag 'rectangular
         (fn [x y] (tag (make-from-real-imag x y))))
    (put 'make-from-mag-ang 'rectangular
         (fn [r a] (tag (make-from-mag-ang r a))))
    'done))

(defn install-polar-package []
  (letfn [(magnitude [z] (first z))
          (angle [z] (second z))
          (make-from-real-imag [x y]
            (cons (Math/sqrt (+ (Math/square x) (Math/square y)))
                  (Math/atan y x)))
          (make-from-mag-ang [r a] (cons r a))
          (real-part [z]
            (* (magnitude z) (Math/cos (angle z))))
          (imag-part [z]
            (* (magnitude z) (Math/sin (angle z))))
          (tag [x] (attach-tag 'polar x))]
    (put 'real-part '(polar) real-part)
    (put 'imag-part '(polar) imag-part)
    (put 'magnitude '(polar) magnitude)
    (put 'angle '(polar) angle)
    (put 'make-from-real-imag 'polar
         (fn [x y] (tag (make-from-real-imag x y))))
    (put 'make-from-mag-ang 'polar
         (fn [r a] (tag (make-from-mag-ang r a))))
    'done))

(defn type-tag [datum]
  (if (list? datum)
    (first datum)
    (throw (Exception. "Bad tagged datum -- TYPE-TAG"))))

(defn contents [datum]
  (if (list? datum)
    (rest datum)
    (throw (Exception. "Bad tagged datum -- CONTENTS"))))

(defn apply-generic [op & args]
  (let [type-tags (map type-tag args)
        proc (get op type-tags)]
    (if proc
      (apply proc (map contents args))
      (throw (Exception. "No method for these types -- APPLY-GENERIC")))))

(defn real-part [z] (apply-generic 'real-part z))

(defn imag-part [z] (apply-generic 'imag-part z))

(defn magnitude [z] (apply-generic 'magnitude z))

(defn angle [z] (apply-generic 'angle z))

(defn make-from-real-imag [x y]
  ((get 'make-from-real-imag '(rectangular)) x y))

(defn make-from-mag-ang [r a]
  ((get 'make-from-mag-ang '(polar)) r a))

;; message-passing

(defn make-from-real-imag [x y]
  (letfn [(dispatch [op]
            (cond (= op 'real-part) x
                  (= op 'imag-part) y
                  (= op 'magnitude)
                  (Math/sqrt (+ (Math/square x) (Math/square y)))
                  (= op 'angle) (Math/atan y x)
                  :else (throw (Exception. "Unknown operation -- MAKE-FROM-REAL-IMAG" op))))]
    dispatch))

(defn apply-generic [op arg] (arg op))
