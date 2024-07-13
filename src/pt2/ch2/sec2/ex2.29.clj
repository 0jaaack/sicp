(ns pt2.ch2.sec2.ex2.29)

(defn make-mobile [left right]
  '(left right))

(defn make-branch [length structure]
  '(length structure))

(defn left-branch [mobile]
  (first mobile))

(defn right-branch [mobile]
  (second mobile))

(defn branch-length [branch]
  (first branch))

(defn branch-structure [branch]
  (second branch))

(defn total-weight [mobile]
  (defn branch-weight [branch]
    (let [structure (branch-structure branch)]
      (if (number? structure)
        structure
        (total-weight structure))))
  (+ (branch-weight (left-branch mobile))
     (branch-weight (right-branch mobile))))

(defn branch-torque [branch]
  (* (branch-length branch)
     (branch-weight branch)))

(defn balanced-mobile? [mobile]
  (defn balanced-branch? [branch]
    (let [structure (branch-structure branch)]
      (or (number? structure) (balanced-mobile? structure))))
  (and (= (branch-torque (left-branch mobile))
          (branch-torque (right-branch mobile)))
       (and (balanced-branch? (left-branch mobile))
            (balanced-branch? (left-branch mobile)))))

(defn make-mobile [left right]
  (cons left right))

(defn make-branch [length structure]
  (cons length structure))

(defn right-branch [mobile]
  (rest mobile))

(defn branch-structure [branch]
  (rest branch))
