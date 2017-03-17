(ns zenapp.screen.login
  (:require [zenapp.shared.reactcomponents :refer [view alert fb-login-button fb-access-token]]))

(defn get-access-token
  [success-response]
  (let [access-token (.. success-response -accessToken)]
    (js/console.log "callback?")
    (js/console.log (.toString access-token))
    (.toString access-token)))

(defn login-finished
  [error result]
  (cond
    error  (js/console.log "this is error") #_(.alert alert (str "login has error " (.-error result)))
    #_(.isCancelled result) #_(js/console.log "loginn is cancelled")
    :else (-> (.getCurrentAccessToken fb-access-token)
              (.then get-access-token #(js/console.log %)))))

(defn login-view
  []
  (fn []
    [view ]
    [fb-login-button  {:publish-permissions ["publish_actions"]
                       :on-login-finished login-finished
                       :on-logout-finished logout-finished}]) )





