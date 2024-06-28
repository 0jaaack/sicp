(ns pt1.ch2.sec5.ex1.20)

(defn gcd [a b]
  (if (= b 0)
    a
    (gcd b (mod a b))))

; normal order evaluation
(gcd 206 40)
(gcd 40 (mod 206 40))
(if (= (mod 206 40) 0) 40 (gcd (mod 206 40) (mod 40 (mod 206 40)))) ; 1
(gcd (mod 206 40) (mod 40 (mod 206 40)))
(if (= (mod 40 (mod 206 40)) 0) (mod 206 40) (gcd (mod 40 (mod 206 40)) (mod (mod 206 40) (mod 40 (mod 206 40))))) ; 2
(gcd (mod 40 (mod 206 40)) (mod (mod 206 40) (mod 40 (mod 206 40))))
(if (= (mod (mod 206 40) (mod 40 (mod 206 40))) 0) (mod 40 (mod 206 40)) (gcd (mod (mod 206 40) (mod 40 (mod 206 40))) (mod (mod 40 (mod 206 40)) (mod (mod 206 40) (mod 40 (mod 206 40)))))) ; 4
(gcd (mod (mod 206 40) (mod 40 (mod 206 40))) (mod (mod 40 (mod 206 40)) (mod (mod 206 40) (mod 40 (mod 206 40)))))
(if (= (mod (mod 40 (mod 206 40)) (mod (mod 206 40) (mod 40 (mod 206 40)))) 0) (mod (mod 206 40) (mod 40 (mod 206 40))) (gcd (mod (mod 40 (mod 206 40)) (mod (mod 206 40) (mod 40 (mod 206 40)))) (mod (mod (mod 206 40) (mod 40 (mod 206 40))) (mod (mod 40 (mod 206 40)) (mod (mod 206 40) (mod 40 (mod 206 40))))))) ; 7
(mod (mod 206 40) (mod 40 (mod 206 40))) ; 4
; => 18

; applicative order evaluation
(gcd 206 40)
(gcd 40 (mod 206 40)) ; 1
(gcd 40 6)
(gcd 6 (mod 40 6)) ; 2
(gcd 6 4)
(gcd 4 (mod 6 4)) ; 3
(gcd 4 2)
(gcd 2 (mod 4 2)) ; 4
(gcd 2 0)
0
; => 4
