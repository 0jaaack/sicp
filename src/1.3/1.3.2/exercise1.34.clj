(defn f [g]
  (g 2))

(defn square [x]
  (* x x))

(f square)

(f (fn [z] (* z (+ z 1))))

(f f)
