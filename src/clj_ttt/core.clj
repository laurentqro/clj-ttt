(ns clj-ttt.core)

(defn -main
  [& args]
  (println "Hello World"))

(def new-board ["" "" "" "" "" "" "" "" ""])

(defn create-board [& cells]
  (vector cells))

(defn available? [cell]
  (clojure.string/blank? cell))

(defn empty? [cells]
  (every? available? cells))

(defn mark-board [board position mark]
  (assoc board (- position 1)  mark))

(defn get-cell [board position]
  (let [index (- position 1)]
    (nth board index)))

(defn marked? [cell]
  (not (available? cell)))

(defn rows [board]
  (apply partition 3 board))

(defn columns [board]
  (apply mapv vector (rows board)))

(defn left-diagonal [board]
  (map-indexed
   (fn [row-index row] (nth row row-index)) (rows board)))

(defn right-diagonal [board]
  (map-indexed
   (fn [row-index row] (nth row row-index)) (reverse (rows board))))

(defn diagonals [board]
  (concat (left-diagonal board) (right-diagonal board)))

(defn combinations [board]
  (concat (rows board) (columns board) (diagonals board)))

(defn winning-combination? [combination]
  (apply = combination))

(defn win? [board]
  (some winning-combination? (combinations board)))
