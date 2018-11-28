(ns clj-ttt.board)

(defn- available? [cell]
  (clojure.string/blank? cell))

(defn- full? [board]
  (not-any? #(= "" %) board))

(defn- rows [board]
  (apply partition 3 board))

(defn- columns [board]
  (apply mapv vector (rows board)))

(defn- left-diagonal [board]
  (map-indexed
   (fn [row-index row] (nth row row-index)) (rows board)))

(defn- right-diagonal [board]
  (map-indexed
   (fn [row-index row] (nth row row-index)) (reverse (rows board))))

(defn- combinations [board]
  ((juxt rows columns right-diagonal left-diagonal) board))

(defn- winning-combination? [combination]
  (apply = combination))

(defn pristine? [cells]
  (every? available? cells))

(defn get-cell [board position]
  (let [index (- position 1)]
    (nth board index)))

(defn no-win? [board]
  (not-any? winning-combination? (combinations board)))

(defn win? [board]
  (some winning-combination? (partition 3 (flatten (combinations board)))))

(defn tie? [board]
  ((every-pred full? no-win?) board))

(defn mark-board [board position mark]
  (assoc board (- position 1)  mark))

(defn create-board [& cells]
  (vector cells))

(def new-board ["" "" "" "" "" "" "" "" ""])
