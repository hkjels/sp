(ns sp.handlers
    (:require [re-frame.core :refer [register-handler]]
              [sp.db :as db]
              [sp.util :refer [slug-encode a-comment]]))

(register-handler
 :initialize-db
 (fn  [_ _]
   (let [comments (map #(a-comment (:id %)) (:ambitions db/default-db))]
     (-> db/default-db
         (assoc-in [:comments] comments)))))

(register-handler
 :set-ambition
 (fn [db [_ title]]
   (let [ambition (peek (filterv #(= (slug-encode (:title %)) title) (:ambitions db)))]
     (assoc db :ambition ambition))))

(register-handler
 :set-active-panel
 (fn [db [_ active-panel]]
   (-> db
       (assoc-in [:main-menu] (mapv #(assoc % :active? (= active-panel (:panel %))) (:main-menu db)))
       (assoc-in [:active-panel] active-panel))))
