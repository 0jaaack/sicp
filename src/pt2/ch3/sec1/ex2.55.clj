(ns pt2.ch3.sec1.ex2.55)

(first ''abracadabra)

(= (quote abracadabra) 'abracadabra) ;; => true

(= (first ''abracadabra) (first (quote (quote abracadabra)))) ;; => true

(first (quote (quote abracadabra))) ;; => quote
