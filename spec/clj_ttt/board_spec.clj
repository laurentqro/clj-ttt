(ns clj-ttt.board-spec
  (:require [speclj.core :refer :all]
            [clj-ttt.board :refer :all]))

(describe "the board"
  (it "should be empty"
    (should= true (pristine? new-board)))

  (it "can be marked"
    (let [board (mark-board new-board 1 "X")
          cell (get-cell board 1)]
      (should= "X" cell)))

  (it "recognizes a diagonal win"
      (let [board ["X" "" ""
                   "" "X" ""
                   "" "" "X"]]
      (should= true (win? board))))

  (it "recognizes a row win"
      (let [board ["X" "X" "X"
                   "" "" ""
                   "" "" ""]]
        (should= true (win? board))))

  (it "recognizes a column win"
      (let [board ["X" "" ""
                   "X" "" ""
                   "X" "" ""]]
        (should= true (win? board))))

  (it "recognizes a tie"
      (let [board ["X" "X" "O"
                   "O" "O" "X"
                   "X" "O" "X"]]
        (should= true (tie? board))))

  (it "an empty board has no tie"
        (should= false (tie? new-board)))

  (it "shows available moves"
      (should= "23" (apply str (available-moves ["X" "2" "3"]))))

  (it "knows player X should start"
      (should= "X" (current-player-mark new-board)))

  (it "knows the winner is X"
      (let [board ["X" "X" "X"
                   "" "" ""
                   "" "" ""]]
        (should= "X" (winner board))))

  (it "knows the winner is O"
      (let [board ["O" "" ""
                  "" "O" ""
                  "" "" "O"]]
        (should= "O" (winner board)))))

