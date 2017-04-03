(ns zenapp.screen.map
  (:require [zenapp.shared.reactcomponents :refer [view text image touchable-highlight alert mapview mapview-marker]]
            [zenapp.shared.navbutton :refer [nav-button]]
            [zenapp.screen.navigation :refer [nav-wrapper]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]))

(defn populate-neighbours
  [lat lng]
; lat=asin(sin(lat1)*cos(d)+cos(lat1)*sin(d)*cos(tc))
 ;IF (cos(lat)=0)
  ;  lon=lon1      // endpoint a pole
 ;ELSE
 ;   lon=mod(lon1-asin(sin(tc)*sin(d)/cos(lat))+pi,2*pi)-pi
 ;ENDIF

  )

(def styles
  {:full-screen-view {:position "absolute"
                     :align-items "center"
                     :top 0
                     :left 0
                     :right 0
                     :bottom 0
                     :justify-content "flex-end"}
   :full-screen-map { :top 0
                     :left 0
                     :right 0
                     :bottom 0
                     :position "absolute" } })

(defn show-alert [title]
      (.alert alert title))

(defn map-view
  [navigation]
  (let [my-location (subscribe [:get-my-location])
        delta (subscribe [:get-delta])
        neighbor-locations (subscribe [:get-neighbor-locations]) ]
    (fn []
      (let [{:keys [latitude longitude]} @my-location
            {delta-lat :latitude delta-lng :longitude} @delta ]
        [view {:style (:full-screen-view styles)}
         [mapview {:zoom-enabled true
                   :shows-user-location true
                   :shows-my-location-button true
                   :on-region-change-complete #(js/console.log "REgion changed" %)
                   :style (:full-screen-map styles)
                   :region {:latitude latitude  :longitude longitude  :latitude-delta delta-lat :longitude-delta delta-lng}}
         [mapview-marker {:coordinate {:latitude latitude :longitude longitude}}]]
         [nav-button navigation {:position "absolute" :top 20 :left 0}]
         ]))))

(def navigation-options
  {:drawer (fn []
             {:label "Nearby"})})
#_(js/console.log (nav-wrapper map-view "Nearby"))
(def navigable-map-view
  (nav-wrapper map-view navigation-options))
