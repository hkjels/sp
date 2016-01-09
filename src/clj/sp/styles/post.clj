(ns sp.styles.post
  (:refer-clojure :exclude '[+ - * /])
  (:require [garden.arithmetic :refer [+ - * /]]
            [garden.color :refer [rgb]]
            [garden.def :refer [defstyles defkeyframes]]
            [garden.units :refer [percent vw em px]]
            [sp.styles.config :refer [air]]
            [sp.styles.flex :as flex]))

(def grid
  [:.posts-grid :.ms-srch-group-content {:width (percent 100)
                                         :height (percent 100)
                                         :padding 0
                                         :margin 0}
   [:& (merge (flex/layout :row) (flex/align :stretch :center) ^:prefix {:flex-wrap :wrap})]])

(def intro
  [:.post-intro {:background-color :white
                 :box-sizing :border-box
                 :border [[(px 1) :solid :lightgray]]
                 :color :inherit
                 :display :inline-block
                 :max-width (vw 30)
                 :margin air
                 :min-width (vw 24)
                 :position :relative
                 :text-decoration :none
                 :text-align :center}
   [:& ^:prefix {:flex [[1 1 (vw 25)]]}]
   [:.location {:background-color (rgb 228 2 46)
                :padding [[(* air 0.5) (* air 2)]]
                :color :white
                :position :absolute
                :left (percent 50)
                :top (- (px 2))
                :z-index 2
                :font-size (em 0.7)
                :text-transform :uppercase
                :transform "translateX(-50%) translateZ(0)"}]
   [:&:hover
    [:.photo
     [:&:after {:transform "translateX(-50%) translateY(3%)"}]
     [:img {:-webkit-filter "grayscale(0)"
            :filter "grayscale(0)"
            :transform "scale(1.4) rotateZ(3deg)"}]]]
   [:small {:display :block
            :font-size (em 0.6)
            :position :relative}]
   [:.photo {:width (percent 100)
             :height (px 150)
             :margin 0
             :padding 0
             :position :relative
             :overflow :hidden}
    [:&:after {:border-width [[0 (em 1.5) (em 1.5) (em 1.5)]]
                :border-style :solid
                :border-color [[:transparent :transparent :white :transparent]]
                :content "' '"
                :display :block
                :position :absolute
                :bottom 0
                :left (percent 50)
                :transition ".5s ease"
                :transform "translateZ(0) translateX(-50%) translateY(100%)"}]
    [:img {:max-height 150
           :max-width (vw 30)
           :width :auto
           :height :auto
           :transition ".3s ease"
           :-webkit-filter "grayscale(1)"
           :filter "grayscale(1)"}]
    [:.icon {:position :absolute
             :color :white
             :top (percent 50)
             :left (percent 50)
             :font-size (em 5)
             :transform "translateX(-50%) translateY(-50%)"}]]
   [:.title {:text-transform :uppercase}]])

(def article
  [:.post
   [:video  {:background-size :cover
             :background-position :center
             :background-repeat :no-repeat
             :height (px 300)
             :width (percent 100)}]])

(defstyles styles [grid intro article])
