(ns sp.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [sp.handlers]
              [sp.subs]
              [sp.routes :as routes]
              [sp.views :as views]
              [sp.config :as config]))

(when config/debug?
  (println "dev mode"))

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init [] 
  (routes/app-routes)
  (re-frame/dispatch-sync [:initialize-db])
  (mount-root))
