(ns pt2.ch1.sec3.ex2.6)

(defn zero [f]
  (fn [x] x))

(defn add-1 [n]
  (fn [f] (fn [x] (f ((n f) x)))))

(add-1 zero)
(add-1 (fn [f] (fn [x] x)))
(fn [f] (fn [x] (f (((fn [f] (fn [x] x)) f) x))))
(fn [f] (fn [x] (f ((fn [x] x) x))))
(fn [f] (fn [x] (f x)))

(defn one [f]
  (fn [x] (f x)))

(add-1 one)
(add-1 (fn [f] (fn [x] (f x))))
(fn [f] (fn [x] (f (((fn [f] (fn [x] (f x))) f) x))))
(fn [f] (fn [x] (f ((fn [x] (f x)) x))))
(fn [f] (fn [x] (f (f x))))

(defn two [f]
  (fn [x] (f (f x))))

(fn [])

(defn add [n m]
  (fn [f] (fn [x] ((n f) ((m f) x)))))
