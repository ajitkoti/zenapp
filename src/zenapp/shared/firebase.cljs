(ns zenapp.shared.firebase)

(def firebase (js/require "firebase"))

(defn init []
  (let [config { :apiKey "AIzaSyBLZ3H8HKwQYtB7HYt-0Fw240pjEh1GPjw",
                :authDomain "zenapp-4186e.firebaseapp.com",
                :databaseURL "https://zenapp-4186e.firebaseio.com",
                :storageBucket "zenapp-4186e.appspot.com",
                :messagingSenderId "616286521860"}  ]
    (.initializeApp firebase (clj->js config))))
