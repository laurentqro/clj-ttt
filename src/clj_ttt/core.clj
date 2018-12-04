(ns clj-ttt.core
  (:require [clj-ttt.game :refer :all]
            [clj-ttt.human-player :refer :all]
            [clj-ttt.computer-player :refer :all]))

(defn -main
  [& args]
  (start-game {"X" human-pick-move "O" computer-pick-move}))
