(ns pt2.ch3.sec4.main)

(defn make-leaf [symbol weight]
  (list 'leaf symbol weight))

(defn leaf? [node]
  (and (seq? node) (= (first node) 'leaf)))

(defn symbol-leaf [node]
  (second node))

(defn weight-leaf [node]
  (last node))

(defn left-branch [tree]
  (first tree))

(defn right-branch [tree]
  (second tree))

(defn symbols [tree]
  (if (leaf? tree)
    (list (symbol-leaf tree))
    (nth tree 2)))

(defn weight [tree]
  (if (leaf? tree)
    (weight-leaf tree)
    (nth tree 3)))

(defn make-code-tree [left right]
  (list left
        right
        (concat (symbols left) (symbols right))
        (+ (weight left) (weight right))))

(defn choose-branch [bit branch]
  (cond (= bit 0) (left-branch branch)
        (= bit 1) (right-branch branch)
        :else (throw (IllegalArgumentException. "bad bit"))))

(defn decode [bits tree]
  (letfn [(decode-1 [bits current-branch]
            (if (empty? bits)
              '()
              (let [next-branch (choose-branch (first bits) current-branch)]
                (if (leaf? next-branch)
                  (cons (symbol-leaf next-branch)
                        (decode-1 (rest bits) tree))
                  (decode-1 (rest bits) next-branch)))))]
    (decode-1 bits tree)))

(defn adjoin-set [x set]
  (cond (empty? set) (list x)
        (< (weight x) (weight (first set))) (cons x set)
        :else (cons (first set) (adjoin-set x (rest set)))))

(defn make-leaf-set [pairs]
  (if (empty? pairs)
    '()
    (adjoin-set (make-leaf (first (first pairs))
                           (second (first pairs)))
                (make-leaf-set (rest pairs)))))
