(ns clj-ttt.core)

(defn -main
  [& args]
  (println "Hello World"))

(def new-board ["" "" "" "" "" "" "" "" ""])

(defn is-available? [cell]
  (clojure.string/blank? cell)
  )

(defn is-empty? [cells]
  (every? is-available? cells)
  )
