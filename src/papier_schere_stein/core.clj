(ns papier-schere-stein.core
  (:gen-class))

(defn get_user_input []
  (println "Gib ein - Papier (p), Schere (s) oder Stein (n) - oder beende mit (x):")
  (let [user-input (read-line)]
    (cond
      (= user-input "s") "Schere"
      (= user-input "n") "Stein"
      (= user-input "p") "Papier"
      (= user-input "x") (System/exit 0)
      :else "ungueltig")))

(defn get_result [player1 player2]
  (let [combination [player1 player2]]
    (cond
      (= player1 player2) 0
      (= combination ["Papier" "Stein"]) 1
      (= combination ["Stein" "Papier"]) 2
      (= combination ["Stein" "Schere"]) 1
      (= combination ["Schere" "Stein"]) 2
      (= combination ["Schere" "Papier"]) 1
      (= combination ["Papier" "Schere"]) 2)))

(defn play_game []
  (let [computer (rand-nth ["Stein" "Papier" "Schere"])
        human_player (get_user_input)
        result (get_result computer human_player)]
    (println "Du hast" human_player)
    (println "Der Computer hat" computer)
    (cond
      (= human_player "ungueltig") (println "Probiere bitte noch mal!")
      (= result 0) (println "Unentschieden!")
      (= result 1) (println "Der Computer gewinnt!")
      (= result 2) (println "Du gewinnst!"))))

(loop []
  (play_game)
  (recur))
