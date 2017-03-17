(ns zenapp.screen.app
  (:require [zenapp.screen.login :refer [login-view]]
            [zenapp.screen.map :refer [map-view]]))


(defn app-component []
  #_[map-view]
  [login-view]
  )
