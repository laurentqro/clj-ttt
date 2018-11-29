(ns clj-ttt.io
  (:require [clj-ttt.board :refer :all]))

(defn- format-row [board]
  (clojure.string/join " | " board))

(defn- format-board [board]
  (->> board
       (rows)
       (map format-row)
       (clojure.string/join "\n")))

(defn greetings []
  (println "Welcome to Tic Tac Toe"))

(defn display-board [board]
  (->> board
       (format-board)
       (println)))

(defn announce-winner [board]
  (display-board board)
  (printf "%s wins!\n" (winner board)))

(defn announce-tie [board]
  (display-board board)
  (println "Tie"))

(defn goodbye []
  (println "Goodbye!"))
