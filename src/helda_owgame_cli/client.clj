(ns helda-owgame-cli.client
  (:require
    [clj-http.client :refer [get]]
    )
  )

(defn find-entities
  ([world]
    (get
      "http://localhost:3000/entities/entities-by-world"
      {
        :query-params {:world world}
        :content-type :json
        :as :json-strict
        }
      )
    )
  ([world models]
    (get
      "http://localhost:3000/entities/entities-by-models"
      {
        :query-params {:world world :models models}
        :content-type :json
        :as :json-strict
        }
      )
    )
  ([world models tags]
    (get
      "http://localhost:3000/entities/entities-by-tags-and-models"
      {
        :query-params {:world world :models models :tags tags}
        :content-type :json
        :as :json-strict
        }
      )
    )
  )

(defn perform-action [world source-id target-id action-ctx]

  )
