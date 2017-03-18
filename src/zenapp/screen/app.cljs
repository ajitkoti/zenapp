(ns zenapp.screen.app
  (:require [zenapp.screen.login :refer [login-view navigable-login-view]]
            [zenapp.screen.map :refer [navigable-map-view map-view]]
            [zenapp.shared.reactcomponents :refer [drawer-navigator]]
            ))

(def routes
  {:Nearby {:screen navigable-map-view}
   :Login {:screen navigable-login-view} })

(defonce app-component
  (drawer-navigator routes)
  #_map-view
  #_[login-view]
  )

