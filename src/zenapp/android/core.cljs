(ns zenapp.android.core
  (:require [reagent.core :as r]
            [re-frame.core :refer [dispatch-sync]]
            [zenapp.shared.reactcomponents :refer [app-registry]]
            [zenapp.screen.app :refer [app-component]]
            [zenapp.events]
            [zenapp.subs]))

(defn app-root []
  (fn []
    [app-component]))

(defn init []
  (dispatch-sync [:initialize-db])
  (js/console.log (r/reactify-component app-root) (clj->js app-component))
      (.registerComponent app-registry "zenapp" #(r/reactify-component app-root)))
