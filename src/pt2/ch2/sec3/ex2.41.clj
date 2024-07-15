(ns pt2.ch2.sec3.ex2.41
  (:require [pt2.ch2.sec3.main :refer [flatmap enumerate-interval]]))

(defn unique-triples [n]
  (flatmap (fn [i]
             (map (fn [x] (cons i x))
                  (remove (second i) (remove (first i) (enumerate-interval 1 n)))))
           (flatmap (fn [i]
                      (map (fn [x] (list i x))
                           (remove i (enumerate-interval 1 n))))
                      (enumerate-interval 1 n))))

(defn unique-triples [n]
  (->> (enumerate-interval 1 n)
       (flatmap (fn [i]
                  (map (fn [j] (list i j))
                       (remove i (enumerate-interval 1 n)))))
       (flatmap (fn [pair]
                  (map (fn [j] (concat pair (list j)))
                       (->> (enumerate-interval 1 n)
                            (remove (first pair))
                            (remove (second pair))))))))

(unique-triples 5)
;; => ((1 2 3) (1 2 4) (1 2 5) (1 3 2) (1 3 4) (1 3 5) (1 4 2) (1 4 3) (1 4 5) (1 5 2) (1 5 3) (1 5 4) (2 1 3) (2 1 4) (2 1 5) (2 3 1) (2 3 4) (2 3 5) (2 4 1) (2 4 3) (2 4 5) (2 5 1) (2 5 3) (2 5 4) (3 1 2) (3 1 4) (3 1 5) (3 2 1) (3 2 4) (3 2 5) (3 4 1) (3 4 2) (3 4 5) (3 5 1) (3 5 2) (3 5 4) (4 1 2) (4 1 3) (4 1 5) (4 2 1) (4 2 3) (4 2 5) (4 3 1) (4 3 2) (4 3 5) (4 5 1) (4 5 2) (4 5 3) (5 1 2) (5 1 3) (5 1 4) (5 2 1) (5 2 3) (5 2 4) (5 3 1) (5 3 2) (5 3 4) (5 4 1) (5 4 2) (5 4 3))
