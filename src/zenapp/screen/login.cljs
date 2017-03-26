(ns zenapp.shared.login
  (:require [zenapp.shared.reactcomponents :refer [view alert fb-login-button fb-access-token]]
            [zenapp.shared.firebase :as firebase]))

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
              (.then  #(firebase/firebase-fb-signin (get-access-token %)) ))))

(defn login-view
  []
  (fn []
    [fb-login-button  {:publish-permissions ["publish_actions"]
                       :on-login-finished login-finished
                       :on-logout-finished logout-finished}]) )

(def navigation-options
  {:drawer (fn []
             {:label "Login"})})

(def navigable-login-view
  (nav-wrapper login-view navigation-options))
