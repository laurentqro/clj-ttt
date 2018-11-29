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

(describe "a full human vs. human game with X win"
          (it "should go through to the end"
              (should-contain
                "X wins"
                (human-v-human-game-output moves-for-x-win))))

(describe "a full human vs. human game with O win"
          (it "should go through to the end"
              (should-contain
               "O wins"
               (human-v-human-game-output moves-for-o-win))))

(describe "a full human vs. human game with tie"
          (it "should go through to the end"
              (should-contain
               "Tie"
               (human-v-human-game-output moves-for-tie))))
