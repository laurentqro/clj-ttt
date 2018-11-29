(ns clj-ttt.io
  (:require [clj-ttt.board :refer :all]))

(defn- display [output]
  (println output))

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
