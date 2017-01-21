(ns zenapp.subs
  (:require [re-frame.core :refer [reg-sub]]))

(reg-sub
  :get-my-location
  (fn [db _]
    (:my-location db)))
