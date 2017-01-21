(ns zenapp.shared.ui
  (:require [reagent.core :as r :refer [atom]]
            [zenapp.shared.reactcomponents :refer [view text image touchable-highlight alert]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]))

(defn show-alert [title]
      (.alert alert title))

(defn app-component []
  (let [my-location (subscribe [:get-my-location])]
    (fn []
      [view {:style {:flex-direction "column" :margin 40 :align-items "center"}}
       [text {:style {:font-size 30 :font-weight "100" :margin-bottom 20 :text-align "center"}} (str "latitude" (:latitude @my-location))]
       [text {:style {:font-size 30 :font-weight "100" :margin-bottom 20 :text-align "center"}} (str "longitude" (:longitude @my-location))]
       [touchable-highlight {:style {:background-color "#999" :padding 10 :border-radius 5}
                             :on-press #(show-alert "HELLO!")}
        [text {:style {:color "white" :text-align "center" :font-weight "bold"}} "press me"]]])))
