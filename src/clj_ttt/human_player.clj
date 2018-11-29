(ns clj-ttt.human-player)

(defn pick-move []
  (println "Please pick a move: ")
  (Integer/parseInt (read-line)))
