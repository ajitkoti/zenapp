(ns zenapp.screen.profile
  (:require [zenapp.shared.ui :refer [header card card-section nav-menu-img]]
            [zenapp.shared.reactcomponents :refer [view text image]]))

(defn profile-view
  []
  (fn []
    [view {:flex 1}
     [header "Hello"]
     [card
      [card-section
       [image {:source nav-menu-img :style {:width 50 :height 50}}]
       [text "Rohit thadani"]]]]))
