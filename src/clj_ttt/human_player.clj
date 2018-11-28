(ns clj-ttt.human-player)

(defn pick-move []
  (Integer/parseInt (read-line)))
