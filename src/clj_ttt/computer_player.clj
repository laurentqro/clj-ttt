(ns clj-ttt.computer-player
  (:require [clj-ttt.board :refer :all]))

(def win 1)
(def loss -1)
(def tie 0)

(defn- evaluate-result [board]
  (cond
    (tie? board) tie
    (= "X" (winner board)) loss
    (= "O" (winner board)) (* win (available-moves-count board))))

(declare minimax)
(defn- score-move [board]
    (if (game-over? board)
      (evaluate-result board)
      (minimax board)))

(defn- max-score [moves]
  (val (apply max-key val moves)))

(defn- min-score [moves]
  (val (apply min-key val moves)))

(defn- score-moves [board]
  (let [moves (available-moves board)
        scores (->> board
                    (available-moves)
                    (map #(score-move (mark-board board (Integer/parseInt %) (current-player-mark board)))))]

  (zipmap moves scores)))

(defn- minimax [board]
  (cond
    (= "X" (current-player-mark board)) (min-score  (score-moves board))
    (= "O" (current-player-mark board)) (max-score  (score-moves board))))

(defn- best-scored-move [moves]
  (key (apply max-key val moves)))

(defn pick-best-move [board]
  (->> board
       (score-moves)
       (best-scored-move)
       (Integer/parseInt)))
