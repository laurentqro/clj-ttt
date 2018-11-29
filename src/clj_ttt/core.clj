(ns clj-ttt.core
  (:require [clj-ttt.board :refer :all]
            [clj-ttt.human-player :refer :all]
            [clj-ttt.io :refer :all]))

(defn play-turn [board]
  (display-board board)

  (let [move       (pick-move)
        mark       (current-player-mark board)
        next-board (mark-board board move mark)]

        (cond
          (win? next-board) (printf "%s wins!" (winner next-board))
          (tie? next-board) (println "Tie" next-board)
          :else (play-turn next-board))
        ))


(defn start-game []
  (play-turn new-board))

(defn -main
  [& args]
  (start-game))
