(ns zenapp.shared.ui
  (:require [reagent.core :as r :refer [atom]]
            [zenapp.shared.reactcomponents :refer [view text image touchable-highlight alert mapview]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]))

(defn show-alert [title]
      (.alert alert title))

(defn app-component []
  (let [my-location (subscribe [:get-my-location])]
    (fn []
      [view {:style {:position "absolute" :align-items "center" :top 0 :left 0 :right 0 :bottom 0 :justify-content "flex-end"}}
       #_[text {:style {:font-size 30 :font-weight "100" :margin-bottom 20 :text-align "center"}} (str "latitude" (:latitude @my-location))]
       #_[text {:style {:font-size 30 :font-weight "100" :margin-bottom 20 :text-align "center"}} (str "longitude" (:longitude @my-location))]
       [mapview {:initial-region {:latitude 37.78825  :longitude -121.955  :latitude-delta 0.0922 :longitude-delta 0.0421} :style { :top 0 :left 0 :right 0 :bottom 0 :position "absolute"}} ]
       #_[touchable-highlight {:style {:background-color "#999" :padding 10 :border-radius 5}
                             :on-press #(show-alert "HELLO!")}
        #_[text {:style {:color "white" :text-align "center" :font-weight "bold"}} "press me"]]])))
