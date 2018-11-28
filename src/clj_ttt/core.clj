(ns clj-ttt.core
  (:require [clj-ttt.board :refer :all]
            [clj-ttt.human-player :refer :all]))

(defn -main
  [& args]
  (println "Hello World"))

(defn play-turn [board]
  (let [move (pick-move)
        mark (current-player-mark board)]
    (mark-board board move mark)))
