(ns sp.styles.flex
  (:refer-clojure :exclude '[+ - * /])
  (:require [garden.arithmetic :refer [+ - * /]]
            [garden.units :refer [percent vw em px]]))

(defn layout [direction]
  ^:prefix {:display :flex
            :flex-direction direction})

(defn align
  ([both]
   ^:prefix {:align-items both
             :justify-content both})
  ([h v]
   ^:prefix {:align-items h
             :justify-content v}))

(def styles
  [[:.layout :.layout-row (layout :row)]
   [:.layout-column (layout :column)]
   [:.layout-wrap ^:prefix {:flex-wrap :wrap}]
   [:.between (align :space-between)]
   [:.around (align :space-around)]
   [:.stretch (align :stretch)]
   [:.stretch-center (align :stretch :center)]
   [:.center (align :center)]])
