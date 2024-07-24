(ns pt2.ch3.sec1.main)

'(a b c d)

'(23 45 17)

'((Norah 12) (Molly 9) (Anna 7) (Lauren 6) (Chalotte 4))

(def a 1)

(def b 2)

(list a b) ;; => (1 2)

(list 'a 1) ;; => (a 1)

(list 'a 'b) ;; => (a b)

(list 'a b) ;; => (a 2)

(first '(a b c)) ;; => a

(rest '(a b c)) ;; => (b c)

(defn memq [item x]
  (cond
    (empty? x) false
    (= item (first x)) x
    :else (memq item (rest x))))

(memq 'apple '(pear banana prune)) ;; => false

(memq 'apple '(x (apple sauce) y apple pear)) ;; => (apple pear)
