(ns student.core
  (:require [student.data :as data]
            [student.database :as db]
            [student.web :as web]))

(defn -main []

  (println "All student" data/all-students)

  (println "Pass students:" data/passed-students)

  (println "Total marks" data/total-marks)

  (println "Average marks" data/avg-marks)

  (db/create-table)
  (db/insert-data)

  (println "Database records" (db/read-data))

  (web/start-server)

  (println "Server started at http://localhost:3000"))