(ns clj-ttt.game
  (:require [clj-ttt.io :refer :all]
            [clj-ttt.human-player :refer :all]
            [clj-ttt.board :refer :all]))

(defn play [board]
  (display-board board)

  (let [move       (pick-move board)
        mark       (current-player-mark board)
        next-board (mark-board board move mark)]

    (cond
      (win? next-board) (announce-winner next-board)
      (tie? next-board) (announce-tie next-board)
      :else (play next-board))))

(defn start-game []
  (greetings)
  (play new-board)
  (goodbye))
