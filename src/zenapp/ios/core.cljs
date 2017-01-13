(ns zenapp.ios.core
   (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [zenapp.events]
            [zenapp.subs]
            [zenapp.shared.ui :as ui]))

(defn init []
      (dispatch-sync [:initialize-db])
      (.registerComponent app-registry "zenapp" #(r/reactify-component ui/app-component)))
