(ns helda-owgame-cli.core
  (:require
    [helda-owgame-cli.client :refer [find-entities perform-action]]
    )
  )

(def cur-world (atom nil))
(def cur-hero (atom nil))
(def cur-encounter (atom nil))

(defn new-game [world]
  (reset! cur-world world)
  (reset! cur-hero
    (-> world
      (find-entities ["owgame.BattleUnit"] ["hero"])
      :body first
      )
    )
  )

(defn encounter []
  (if-let [world @cur-world]
    (reset! cur-encounter
      (-> @cur-world
        (find-entities ["owgame.BattleUnit"] ["npc"])
        :body first
        )
      )
    "Start (new-game) first!"
    )
  )

(defn fight []
  (if-let [hero @cur-hero]
    (if-let [encounter @cur-encounter]
      (:body
        (perform-action :fight (:id hero) (:id encounter) {})
        )
      "Choose (encounter) first!"
      )
    "Start (new-game) first!"
    )
  )
