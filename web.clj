(ns student.web
  (:require [ring.adapter.jetty :as jetty]
            [ring.util.response :as response]
            [student.data :as data]
            [student.database :as db]))

(defn my-app [req]
  (let [path (:uri req)]

    (cond

      (= path "/")
      (response/response "Welcome to Student Data Pipeline")

      (= path "/students")
      (response/response
       (pr-str data/all-students))

      (= path "/passed")
      (response/response
       (pr-str data/passed-students))

      (= path "/database")
      (response/response
       (pr-str (db/read-data)))

      :else
      (response/not-found "Page not found"))))

;; Start server
(defn start-server []
  (jetty/run-jetty my-app
                   {:port 3000
                    :join? false}))