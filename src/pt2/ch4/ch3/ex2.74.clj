(ns pt2.ch4.ch3.ex2.74)

;; a

(defn get-record [division name records]
  ((get division :get-record) name records))

;; b

(defn get-salary [division name records]
  (let [record (get-record division name records)]
    (if record
      ((get division :get-salary) record)
      (throw (Exception. "Record not found -- GET-SALARY")))))

;; c

(defn make-file [division records]
  (cons division records))

(defn division [file]
  (first file))

(defn records [file]
  (rest file))

(defn find-employee-record [name files]
  (if (empty? files)
    (throw (Exception. "Record not found -- FIND-EMPLOYEE-RECORD"))
    (let [file (first files)
          record (get-record name (division file) (records file))]
      (if record
        record
        (find-employee-record name (rest files))))))
