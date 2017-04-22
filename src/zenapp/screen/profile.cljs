(ns zenapp.screen.profile
  (:require [zenapp.shared.ui :refer [header card card-section nav-menu-img]]
            [zenapp.shared.reactcomponents :refer [view text image touchable-highlight image-picker]]))

(defn show-image-cropper
  [path]
  (-> (.openCropper image-picker (clj->js {:path path :width 300 :height 400}))
      (.then #(js/console.log %))))

(defn show-image-picker
  []
  (-> (.openPicker image-picker {:width 300, :height 400, :cropping true})
      (.then #(show-image-cropper (:path (js->clj % :keywordize-keys true))))))



(defn profile-view
  []
  (fn []
    [view {:flex 1}
     [header "Hello"]
     [card
      [card-section
       [touchable-highlight {:on-press show-image-picker}
        [image {:source nav-menu-img :style {:width 50 :height 50}}]]

       [text "Rohit thadani"]]]]))


