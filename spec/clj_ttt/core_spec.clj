(ns clj-ttt.core-spec
  (:require [speclj.core :refer :all]
            [clj-ttt.core :refer :all]))

(describe "the board"
  (it "should be empty"
    (should= true (empty? new-board)))

  (it "can be marked"
    (let [board (mark-board new-board 1 "X")
          cell (get-cell board 1)]
    (should= true (marked? cell)))))

