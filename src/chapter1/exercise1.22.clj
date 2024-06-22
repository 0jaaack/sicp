(ns chapter1.exercise1.22
  (:require [chapter1.1.2.6 :refer [prime?]]))

(defn runtime [] (System/currentTimeMillis))

(defn report-prime [elapsed-time n]
  (prn n " *** " elapsed-time))

(defn start-prime-test [n start-time]
  (if (prime? n)
    (report-prime (- (runtime) start-time) n)))

(defn timed-prime-test [n]
  (start-prime-test n (runtime)))

(defn search-for-primes [start-number]
  (timed-prime-test start-number)
  (search-for-primes (+ start-number 1)))

(search-for-primes 1000)

(search-for-primes 100000)

(search-for-primes 1000000)