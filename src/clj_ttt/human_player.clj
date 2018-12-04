(ns clj-ttt.human-player
  (:require [clj-ttt.board :refer :all]
            [clj-ttt.io :refer :all]))

(defn- valid? [board input]
  (-> board
      (available-moves)
      (.contains input)))

(defn human-pick-move [board]
  (prompt-move)

  (let [input (read-line)]
    (if (valid? board input)
      (Integer/parseInt input)
      (do
        (display-invalid-input-message)
        (display-board board)
        (recur board)))))
