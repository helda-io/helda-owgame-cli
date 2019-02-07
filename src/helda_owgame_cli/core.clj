(ns helda-owgame-cli.core
  (:require
    [clj-http.client :refer [find-entities perform-action]]
    )
  )

(def cur-world (atom nil))
(def cur-hero (atom nil))
(def cur-encounter (atom nil))

(defn new-game [world]
  (reset! cur-world world)
  (reset! cur-hero
    (first
      (find-entities @cur-world ["owgame.BattleUnit"] ["hero"])
      )
    )
  )

(defn encounter []
  (if-let [world @cur-world]
    (reset! cur-encounter
      (first
        (find-entities @cur-world ["owgame.BattleUnit"] ["npc"])
        )
      )
    "Start (new-game) first!"
    )
  )

(defn fight []
  (if-let [hero @cur-hero]
    (if-let [encounter @cur-encounter]
      (perform-action :fight (:id hero) (:id encounter) {})
      "Choose (encounter) first!"
      )
    "Start (new-game) first!"
    )
  )
