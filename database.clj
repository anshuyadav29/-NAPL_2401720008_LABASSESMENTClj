(ns student.database
  (:require [clojure.java.jdbc :as jdbc]
            [student.data :as data]))

;; Database connection
(def db
  {:dbtype "sqlite"
   :dbname "students.db"})
(defn create-table []
  (try
    (jdbc/execute!
     db
     ["CREATE TABLE IF NOT EXISTS students
       (id INTEGER PRIMARY KEY,
        name TEXT,
        marks INTEGER)"])

    (println "Table created")

    (catch Exception e
      (println "Error:" (.getMessage e)))))

(defn insert-data []
  (try
    (doseq [s data/students]
      (jdbc/insert! db :students
                    {:id (:id s)
                     :name (:name s)
                     :marks (:marks s)}))

    (println "Data added....DONE")

    (catch Exception e
      (println "Insert error:" (.getMessage e)))))

(defn read-data []
  (try
    (jdbc/query db ["SELECT * FROM students"])

    (catch Exception e
      (println "Read error:" (.getMessage e))
      [])))