(ns helda-owgame-cli.core)

(defn new-game [world]
  (first
    (find-entities ["hero"])
    )
  )

(defn encounter []
  (first
    (find-entities ["npc"])
    )
  )

(defn fight [target-id]
  (perform-action target-id)
  )
