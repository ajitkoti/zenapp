(ns zenapp.shared.ui
  (:require [zenapp.shared.reactcomponents :refer [touchable-opacity image view text]]))

(def nav-menu-img (js/require "./images/navmenu.png"))
(def style
  {:button-container {:width 30 :height 30}
   :bubble           {:paddingHorizontal 8
                      :paddingVertical   2
                      :borderRadius      2
                      :width             30
                      :height            30}
   :nav-button       {:width             40
                      :paddingHorizontal 5
                      :marginHorizontal  10
                      :backgroundColor   "rgba(255,255,255,0.7)"}
   :header-text      {:font-size 20}
   :header-view      {:background-color "lightgray"
                      :justify-content  "center"
                      :align-items      "center"
                      :height           60
                      :padding-top      15
                      :shadow-color     "black"
                      :shadow-offset    {:width 0 :height 2}
                      :shadow-opacity   0.1
                      :elevation        8
                      :position         "relative"}
   :nav-button-image {:height 30
                      :width  30}
   :card             {:border-width        1
                      :border-radius       2
                      :border-color        "#ddd"
                      :border-bottom-width 0
                      :shadow-color        "#000"
                      :shadow-offset       {:width 0 :height 2}
                      :shadow-opacity      0.1
                      :shadow-radius       2
                      :elevation           1
                      :margin-left         5
                      :margin-right        5
                      :margin-top          5}
   :card-section     {:border-bottom-width 1
                      :padding             5
                      :background-color    "#fff"
                      :justify-content     "flex-start"
                      :flex-direction      "row"
                      :border-color        "#ddd"
                      :position            "relative"}
   })

(defn nav-button
  [navigation extra-styles]
  [view {:style (merge (:button-container style) extra-styles)}
   [touchable-opacity {:style    [(:bubble style) (:nav-button style)]
                       :on-press #(.navigate navigation "DrawerOpen")}
    [image {:source nav-menu-img :style (:nav-button-image style)}]]])

(defn header
  [header-text]
  [view {:style (:header-view style)}
   [text {:style (:header-text style)} header-text]])

(defn card
  [& components]
  [view {:style (:card style)}
   components])

(defn card-section
  [& components]
  [view {:style (:card-section style)}
   components])


