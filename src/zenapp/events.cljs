(ns zenapp.events
  (:require
   [re-frame.core :refer [reg-event-db after dispatch]]
   [zenapp.shared.firebase :as firebase]
   [clojure.spec :as s]
   [zenapp.db :as db :refer [app-db]]))

;; -- Interceptors ------------------------------------------------------------
;;
;; See https://github.com/Day8/re-frame/blob/master/docs/Interceptors.md
;;
(defn check-and-throw
  "Throw an exception if db doesn't have a valid spec."
  [spec db [event]]
  (when-not (s/valid? spec db)
    (let [explain-data (s/explain-data spec db)]
      (throw (ex-info (str "Spec check after " event " failed: " explain-data) explain-data)))))

(def validate-spec
  (if goog.DEBUG
    (after (partial check-and-throw ::db/app-db))
    []))

;;axios
(def axios (js/require "axios"))
;;sample
;;(-> (.get axios "http://rallycoding.herokuapp.com/api/music_albums")
;;       (.then #(as-> (.-data %) $
;;                   (js->clj $ :keywordize-keys true)
;;                   (dispatch [:set-album-list $]))))


;; -- Handlers --------------------------------------------------------------
(reg-event-db
 :set-position
 (fn [db [_ {:keys [coords]} ]]
   (let [{:keys [latitude longitude]} coords]
   (js/console.log "set " (clj->js [latitude longitude]))
     (.set firebase/geofire "ajitkoti" (clj->js  [latitude longitude])))
   (assoc db :my-location coords)))

(reg-event-db
 :initialize-db
 (fn [_ _]
   (.watchPosition navigator.geolocation
                         #(dispatch [:set-position (js->clj % :keywordize-keys true)])
                         #(js/console.log "Error getting position" %)
                         (clj->js {:enableHighAccuracy false :timeout 20000, :maximumAge 1000}))
  app-db  ))


