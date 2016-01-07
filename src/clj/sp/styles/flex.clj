(ns sp.styles.flex
  (:refer-clojure :exclude '[+ - * /])
  (:require [garden.arithmetic :refer [+ - * /]]
            [garden.units :refer [percent vw em px]]))

(defn layout [direction]
  {:display :flex
   :flex-direction direction})

(defn align
  ([both]
   {:align-items both
    :justify-content both})
  ([h v]
   {:align-items h
    :justify-content v}))

(def styles
  [[:.layout :.layout-row ^:prefix (layout :row)]
   [:.layout-column ^:prefix (layout :column)]
   [:.layout-wrap ^:prefix {:flex-wrap :wrap}]
   [:.between ^:prefix (align :space-between)]
   [:.around ^:prefix (align :space-around)]
   [:.stretch ^:prefix (align :stretch)]
   [:.stretch-center ^:prefix (align :stretch :center)]
   [:.center ^:prefix (align :center)]])
