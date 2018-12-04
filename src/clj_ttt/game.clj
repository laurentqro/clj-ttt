(ns clj-ttt.game
  (:require [clj-ttt.io :refer :all]
            [clj-ttt.human-player :refer :all]
            [clj-ttt.board :refer :all]))

(defn play [board move-functions]
  (display-board board)

  (let [mark       (current-player-mark board)
        move       ((get move-functions mark) board)
        next-board (mark-board board move mark)]

    (cond
      (win? next-board) (announce-winner next-board)
      (tie? next-board) (announce-tie next-board)
      :else (recur next-board move-functions))))

(defn start-game [move-functions]
  (greetings)
  (play new-board move-functions)
  (goodbye))
