(ns clj-ttt.core)

(defn -main
  [& args]
  (println "Hello World"))

(def new-board ["" "" "" "" "" "" "" "" ""])

(defn available? [cell]
  (clojure.string/blank? cell))

(defn empty? [cells]
  (every? available? cells))

(defn mark-board [board position mark]
  (assoc board (- position 1)  mark))

(defn get-cell [board position]
  (let [index (- position 1)]
  (nth board index)))

(defn marked? [cell]
  (not (available? cell)))
