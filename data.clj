(ns student.data)
(def students
  [{:id 1 :name "Anna" :marks 85}
   {:id 2 :name "Rihana" :marks 45}
   {:id 3 :name "hi" :marks 90}
   {:id 4 :name "bi" :marks 35}
   {:id 5 :name "cy" :marks 75}])

(def all-students
  (map (fn [s]
         (assoc s :result
                (if (>= (:marks s) 40)
                  "Pass" "Fail")))
       students))
(def passed-students
  (filter #(= "Pass" (:result %))
          all-students))
(def total-marks
  (reduce + (map :marks students)))
(def avg-marks
  (/ total-marks (count students)))