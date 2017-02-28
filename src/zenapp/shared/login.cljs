(ns zenapp.shared.login
  (:require [zenapp.shared.reactcomponents :refer [view alert fb-login-button fb-access-token]]))

(defn login-view
  []
  (fn []
    [view ]
    [fb-login-button  {:publish-permissions ["publish_actions"]
                       :on-login-finished login-finished
                       :on-logout-finished logout-finished
                       } ]) )


(defn login-finished [error result]
  (cond
    error (.alert alert (str "login has error " (.error result)))
    (.isCancelled result) (.alert alert "loginn is cancelled")
    :else (-> fb-access-token  .getCurrentAccessToken (.then #(.alert alert %)))) )


