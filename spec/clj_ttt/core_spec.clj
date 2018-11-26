(ns clj-ttt.core-spec
  (:require [speclj.core :refer :all]
            [clj-ttt.core :refer :all]))

(describe "the board"
  (it "should be empty"
    (should= true (is-empty? new-board))))
