(ns zenapp.screen.navigation
  (:require [reagent.core :as r]))

(defn nav-wrapper [component nav-options]
  (let [opts (clj->js nav-options)
        comp (r/reactify-component
               (fn [{:keys [navigation]}]
                 [component navigation]))]
    (aset comp "navigationOptions" opts)
    comp))

