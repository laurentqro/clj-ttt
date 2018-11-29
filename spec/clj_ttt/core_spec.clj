(ns clj-ttt.core-spec
  (:require [speclj.core :refer :all]
            [clj-ttt.core :refer :all]
            [clj-ttt.board :refer :all]
            [clj-ttt.human-player :refer :all]))

(def moves-for-x-win ["1" "5" "2" "8" "3"])
(def moves-for-o-win ["1" "9" "2" "3" "4" "6"])
(def moves-for-tie   ["1" "5" "2" "3" "7" "4" "6" "8" "9"])

(defn- input [moves]
  (clojure.string/join "\n" moves))

(defn- human-v-human-game-output [moves]
  (with-out-str
    (with-in-str (input moves)
      (start-game))))

(describe "a human vs. human game"
          (it "greets the players"
              (should-contain
               "Welcome"
               (human-v-human-game-output moves-for-x-win)))

          (it "announces X win"
              (should-contain
                "X wins"
                (human-v-human-game-output moves-for-x-win)))

          (it "announces O win"
              (should-contain
               "O wins"
               (human-v-human-game-output moves-for-o-win)))

          (it "announces tie"
              (should-contain
               "Tie"
               (human-v-human-game-output moves-for-tie)))

          (it "displays the board"
              (should-contain
               "1 | 2 | 3\n4 | 5 | 6\n7 | 8 | 9"
               (human-v-human-game-output moves-for-tie))))
