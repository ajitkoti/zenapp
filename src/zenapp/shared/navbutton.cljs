(ns zenapp.shared.navbutton
  (:require [zenapp.shared.reactcomponents :refer [touchable-opacity image view]]))

(def nav-menu-img (js/require "./images/navmenu.png"))
(def style
  {:button-container {:width 30 :height 30}
   :bubble {:paddingHorizontal 8
            :paddingVertical 2
            :borderRadius 2
            :width 30
            :height 30
            }
   :button {:width 40
            :paddingHorizontal 5
            :marginHorizontal 10
            :backgroundColor "rgba(255,255,255,0.7)"
            }
   :image {:height 30
           :width 30 }
   })

(defn nav-button
  [navigation extra-styles]
  [view {:style (merge (:button-container style) extra-styles)}
  [touchable-opacity {:style [(:bubble style) (:button style)]
                      :on-press #(.navigate navigation "DrawerOpen")}
   [image {:source nav-menu-img :style (:image style)}]]] )



