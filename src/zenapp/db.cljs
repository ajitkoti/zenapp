(ns zenapp.db
  (:require [clojure.spec :as s]))

;; spec of app-db
(s/def ::greeting string?)
(s/def ::app-db
  (s/keys :req-un [::greeting]))

;; initial state of app-db
(def app-db
  {:my-location {:latitude 37.35410 :longitude -121.95523}
   :delta {:latitude 0.0922 :longitude 0.0421}
   :neighbor-locations [{}] })
