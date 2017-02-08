(ns zenapp.subs
  (:require [re-frame.core :refer [reg-sub]]))

(reg-sub
  :get-my-location
  (fn [db _]
    (:my-location db)))

(reg-sub
  :get-delta
  (fn [db _]
    (:delta db)))

(reg-sub
  :get-neighbor-locations
  (fn [db _]
    (:neighbor-locations db)))
