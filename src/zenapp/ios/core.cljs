(ns zenapp.ios.core
   (:require [reagent.core :as r]
            [re-frame.core :refer [dispatch dispatch-sync]]
            [zenapp.events]
            [zenapp.subs]
            [zenapp.shared.reactcomponents :refer [app-registry]]
            [zenapp.screen.app :refer [app-component]]))

(defn app-root []
  (fn []
    [app-component]))

(defn init []
      (dispatch-sync [:initialize-db])
      (.registerComponent app-registry "zenapp" #(r/reactify-component app-root)))
