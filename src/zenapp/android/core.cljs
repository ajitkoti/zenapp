(ns zenapp.android.core
  (:require [reagent.core :as r]
            [re-frame.core :refer [dispatch-sync]]
            [zenapp.shared.reactcomponents :refer [app-registry]]
            [zenapp.shared.ui :refer [app-component]]
            [zenapp.events]
            [zenapp.subs]))

(defn app-root []
  (app-component))

(defn init []
  (dispatch-sync [:initialize-db])
      (.registerComponent app-registry "zenapp" #(r/reactify-component app-root)))
