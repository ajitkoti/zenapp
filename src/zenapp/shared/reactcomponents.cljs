(ns zenapp.shared.reactcomponents
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))
(def MapView (js/require "react-native-maps"))

(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))
(def image (r/adapt-react-class (.-Image ReactNative)))
(def touchable-highlight (r/adapt-react-class (.-TouchableHighlight ReactNative)))
(def alert (.-Alert ReactNative))
(def mapview (r/adapt-react-class MapView))
(def mapview-marker (r/adapt-react-class (.-Marker MapView)))
(def scrollview (r/adapt-react-class (.-ScrollView ReactNative)))

