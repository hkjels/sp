(ns sp.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :refer [register-sub]]))

(doseq [generic [:top-menu :main-menu :bottom-menu
                 :ambitions :active-panel :ambition]]
  (register-sub
   generic
   (fn [db]
     (reaction (generic @db)))))

(register-sub
 :comments
 (fn [db [_ parent]]
   (let [comments (filterv #(= (:parent %) parent) (:comments @db))]
     (reaction comments))))
