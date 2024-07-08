(ns pt2.ch2.sec1.ex2.19)

(def us-coins '(50 25 10 5 1))
(def uk-coins '(100 50 20 10 5 2 1 0.5))

(defn no-more? [coin-values]
  (empty? coin-values))

(defn except-first-demoniation [coin-values]
  (rest coin-values))

(defn first-demoniation [coin-values]
  (first coin-values))

(defn cc [amount coin-values]
  (cond
    (= amount 0) 1
    (or (no-more? coin-values) (< amount 0)) 0
    :else
    (+ (cc amount (except-first-demoniation coin-values))
       (cc (- amount (first-demoniation coin-values)) coin-values))))

(cc 100 us-coins)
;; => 292
