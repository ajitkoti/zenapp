(ns zenapp.shared.firebase)

(def firebase-def (js/require "firebase"))
(def geofire-def (js/require "geofire"))



(def firebase
  (let [config { :apiKey "AIzaSyBLZ3H8HKwQYtB7HYt-0Fw240pjEh1GPjw",
                :authDomain "zenapp-4186e.firebaseapp.com",
                :databaseURL "https://zenapp-4186e.firebaseio.com",
                :storageBucket "zenapp-4186e.appspot.com",
                :messagingSenderId "616286521860"}  ]
    (.initializeApp firebase-def (clj->js config))))
(def geofire (geofire-def.(-> firebase .database .ref )))
(js/console.log "+YYOYOOYOYOYOYOYOY" geofire)

