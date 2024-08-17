(ns pt2.ch5.ch1.main)
(defn put [op type item] [op type item]) ;; dummy implementation

(defn get [op type] (fn [])) ;; dummy implementation

(defn add [x y] (apply-generic 'add x y))

(defn sub [x y] (apply-generic 'sub x y))

(defn mul [x y] (apply-generic 'mul x y))

(defn div [x y] (apply-generic 'div x y))

(defn install-scheme-number-package []
  (letfn [(tag [x] (attach-tag 'scheme-number x))]
    (put 'add '(scheme-number scheme-number) (fn [x y] (tag (+ x y))))
    (put 'sub '(scheme-number scheme-number) (fn [x y] (tag (- x y))))
    (put 'mul '(scheme-number scheme-number) (fn [x y] (tag (* x y))))
    (put 'div '(scheme-number scheme-number) (fn [x y] (tag (/ x y))))
    (put 'make 'scheme-number (fn [x] (tag x)))
    'done))

(defn make-scheme-number [n] ((get 'make 'scheme-number) n))

(defn install-rational-package []
  (letfn [(number [x] (first x))
          (denom [x] (second x))
          (make-rat [n d] (let [g (gcd n d)]
                            [(/ n g) (/ d g)]))
          (add-rat [x y] (make-rat (+ (* (number x) (denom y))
                                      (* (number y) (denom x)))
                                   (* (denom x) (denom y))))
          (sub-rat [x y] (make-rat (- (* (number x) (denom y))
                                      (* (number y) (denom x)))
                                   (* (denom x) (denom y))))
          (mul-rat [x y] (make-rat (* (number x) (number y))
                                   (* (denom x) (denom y))))
          (div-rat [x y] (make-rat (* (number x) (denom y))
                                   (* (denom x) (number y))))
          (tag [x] (attach-tag 'rational x))]
    (put 'add '(rational rational) (fn [x y] (tag (add-rat x y))))
    (put 'sub '(rational rational) (fn [x y] (tag (sub-rat x y))))
    (put 'mul '(rational rational) (fn [x y] (tag (mul-rat x y))))
    (put 'div '(rational rational) (fn [x y] (tag (div-rat x y))))
    (put 'make 'rational (fn [n d] (tag (make-rat n d))))
    'done))

(defn make-rational [n d]
  ((get 'make 'rational) n d))

(defn install-complex-package []
  (letfn [(make-from-real-imag [x y]
            ((get 'make-from-real-imag 'rectangular) x y))
          (make-from-mag-ang [r a]
            ((get 'make-from-mag-ang 'polar) r a))
          (add-complex [z1 z2]
            (make-from-real-imag (+ (real-part z1) (real-part z2))
                                 (+ (imag-part z1) (imag-part z2))))
          (sub-complex [z1 z2]
            (make-from-real-imag (- (real-part z1) (real-part z2))
                                 (- (imag-part z1) (imag-part z2))))
          (mul-complex [z1 z2]
            (make-from-mag-ang (* (magnitude z1) (magnitude z2))
                               (+ (angle z1) (angle z2))))
          (div-complex [z1 z2]
            (make-from-mag-ang (/ (magnitude z1) (magnitude z2))
                               (- (angle z1) (angle z2))))
          (tag [z] (attach-tag 'complex z))]
    (put 'add '(complex complex) (fn [z1 z2] (tag (add-complex z1 z2))))
    (put 'sub '(complex complex) (fn [z1 z2] (tag (sub-complex z1 z2))))
    (put 'mul '(complex complex) (fn [z1 z2] (tag (mul-complex z1 z2))))
    (put 'div '(complex complex) (fn [z1 z2] (tag (div-complex z1 z2))))
    (put 'make-from-real-imag 'complex
         (fn [x y] (tag (make-from-real-imag x y))))
    (put 'make-from-mag-ang 'complex
         (fn [r a] (tag (make-from-mag-ang r a))))
    'done))

(defn make-complex-from-real-imag [x y]
  ((get 'make-from-real-imag 'complex) x y))

(defn make-complex-from-mag-ang [r a]
  ((get 'make-from-mag-ang 'complex) r a))
