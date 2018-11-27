(ns clj-ttt.core-spec
  (:require [speclj.core :refer :all]
            [clj-ttt.core :refer :all]))

(describe "the board"
  (it "should be empty"
    (should= true (empty? new-board)))

  (it "can be marked"
    (let [board (mark-board new-board 1 "X")
          cell (get-cell board 1)]
      (should= "X" cell)))

  (it "recognizes a diagonal win"
    (let [board (create-board "X" "O" "X"
                              "O" "X" "O"
                              "O" "X" "X")]
      (should= true (win? board))))

  (it "recognizes a row win"
      (let [board (create-board "X" "X" "X"
                                "X" "O" "O"
                                "O" "X" "X")]
        (should= true (win? board))))

  (it "recognizes a column win"
      (let [board (create-board "X" "O" "X"
                                "X" "O" "O"
                                "X" "X" "X")]
        (should= true (win? board))))

  (it "recognizes a tie"
      (let [board (create-board "X" "X" "O"
                                "O" "O" "X"
                                "X" "O" "X")]
        (should= true (tie? board)))))
