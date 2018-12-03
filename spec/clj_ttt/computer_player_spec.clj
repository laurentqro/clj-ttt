(ns clj-ttt.computer-player-spec
  (:require [speclj.core :refer :all]
            [clj-ttt.computer-player :refer :all]
            [clj-ttt.board :refer :all]))

(describe "computer player"
          (it "goes for the win"
              (let [board ["X" "2" "O"
                           "4" "5" "6"
                           "X" "X" "O"]]

                (should= 6
                         (pick-best-move board))))

          (it "goes for the win"
              (let [board ["1" "2" "3"
                           "4" "O" "X"
                           "X" "X" "O"]]

                (should= 1
                         (pick-best-move board))))

          (it "blocks the opponent from winning"
              (let [board ["X" "O" "3"
                           "4" "5" "6"
                           "7" "8" "X"]]

                (should= 5
                         (pick-best-move board))))

          (it "blocks the opponent from winning"
              (let [board ["X" "X" "O"
                           "4" "O" "6"
                           "X" "O" "X"]]

                (should= 4
                         (computer-pick-move board))))


          (it "blocks the opponent from winning"
              (let [board ["X" "X" "3"
                           "4" "O" "6"
                           "7" "8" "9"]]

                (should= 3
                         (pick-best-move board)))))
