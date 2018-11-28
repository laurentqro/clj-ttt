(ns clj-ttt.core-spec
  (:require [speclj.core :refer :all]
            [clj-ttt.core :refer :all]
            [clj-ttt.board :refer :all]
            [clj-ttt.human-player :refer :all]))

(describe "a game turn"
          (it "should ask the current player to pick a move"
              (with-in-str "1"
                (let [board (play-turn new-board)]
                  (should= "X" (get-cell board 1))))))
