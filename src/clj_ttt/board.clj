(ns clj-ttt.board)

(defn- available? [cell]
  (and
   (not= cell "X")
   (not= cell "O")))

(defn rows [board]
  (let [n 3]
    (->> (range n)
         (map #(vec [(nth board (+ 0 (* n %)))
                     (nth board (+ 1 (* n %)))
                     (nth board (+ 2 (* n %)))]))
         (vec))))

(defn- columns [board]
  (apply mapv vector (rows board)))

(defn- diagonals [board]
  [
   [(nth board 0)
    (nth board 4)
    (nth board 8)]
   [(nth board 6)
    (nth board 4)
    (nth board 2)]
   ]
  )

(defn- winning-combination? [combination]
  (apply = combination))

(defn available-moves [board]
  (apply vector (filter available? board)))

(defn available-moves-count [board]
  (count (available-moves board)))

(defn- full? [board]
  (= 0 (available-moves-count board)))

(defn pristine? [board]
  (every? available? board))

(defn- combinations [board]
  (->> board
       ((juxt rows columns diagonals))
       (apply concat)))

(defn- winning-combination [board]
  (->> board
       (combinations)
       (filter winning-combination?)
       (first)))

(defn get-cell [board position]
  (let [index (- position 1)]
    (nth board index)))

(defn winner [board]
  (->> board
       (winning-combination)
       (distinct)
       (first)))

(defn win? [board]
  (->> board
       (combinations)
       (some winning-combination?)))

(defn tie? [board]
  (and
    (full? board)
    ((complement win?) board)))

(defn game-over? [board]
  (or
    (win? board)
    (tie? board)))

(defn mark-board [board position mark]
  (assoc board (- position 1)  mark))

(defn current-player-mark [board]
  (cond
    (odd?  (available-moves-count board)) "X"
    (even? (available-moves-count board)) "O"))

(def new-board ["1" "2" "3" "4" "5" "6" "7" "8" "9"])
