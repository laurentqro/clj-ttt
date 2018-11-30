(ns clj-ttt.io
  (:require [clj-ttt.board :refer :all]))

(defn- display [message]
  (println message))

(defn- format-row [board]
  (clojure.string/join " | " board))

(defn- format-board [board]
  (->> board
       (rows)
       (map format-row)
       (clojure.string/join "\n")))

(defn greetings []
  (display "Welcome to Tic Tac Toe"))

(defn display-board [board]
  (->> board
       (format-board)
       (display)))

(defn display-invalid-input-message []
  (display "You entered an invalid move."))

(defn prompt-move []
  (display "Please enter your move:"))

(defn announce-winner [board]
  (display-board board)
  (printf "%s wins!\n" (winner board)))

(defn announce-tie [board]
  (display-board board)
  (display "Tie"))

(defn goodbye []
  (display "Goodbye!"))
