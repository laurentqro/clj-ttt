(defproject clj-ttt "1.0.1"
  :description "Tic Tac Toe implemented in Clojure"
  :url "https://github.com/laurentqro/clj-ttt"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main clj-ttt.core
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :profiles {:dev {:dependencies [[speclj "3.3.2"]]}}
  :plugins [[speclj "3.3.2"]]
  :test-paths ["spec"])
