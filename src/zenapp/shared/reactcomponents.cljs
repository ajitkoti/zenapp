(ns zenapp.shared.reactcomponents
  (:require [reagent.core :as r]))

(js* "/* @flow */")

(def ReactNative (js/require "react-native"))
(def MapView (js/require "react-native-maps"))
(def FBSDK (js/require "react-native-fbsdk"))
(def react-navigation (js/require "react-navigation"))

;visual
(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))
(def image (r/adapt-react-class (.-Image ReactNative)))
(def touchable-highlight (r/adapt-react-class (.-TouchableHighlight ReactNative)))
(def touchable-opacity (r/adapt-react-class (.-TouchableOpacity ReactNative)))
(def alert (.-Alert ReactNative))
(def mapview (r/adapt-react-class MapView))
(def mapview-marker (r/adapt-react-class (.-Marker MapView)))
(def scrollview (r/adapt-react-class (.-ScrollView ReactNative)))

(def dn (.-DrawerNavigator react-navigation))
(defn drawer-navigator
  [routes]
  (r/adapt-react-class (dn (clj->js routes))))

;login
(def fb-login-button (r/adapt-react-class (.-LoginButton FBSDK)))
#_(def fb-access-token (r/adapt-react-class FBSDK))

(set! js/window.FBSDK FBSDK)
(def fbsdk-static js/window.FBSDK)
(def fb-access-token (.-AccessToken fbsdk-static))


