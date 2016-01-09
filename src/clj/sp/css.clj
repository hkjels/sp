(ns sp.css
  (:refer-clojure :exclude '[+ - * /])
  (:require [garden.arithmetic :refer [+ - * /]]
            [garden.color :refer [rgb rgba]]
            [garden.def :refer [defstyles defkeyframes]]
            [garden.units :refer [percent vw em px]]
            [garden.stylesheet :refer [at-import]]
            [sp.styles.animation :as anim]
            [sp.styles.config :as c]
            [sp.styles.flex :as flex]
            [sp.styles.menues :as menues]
            [sp.styles.post :as post]
            [sp.styles.typography :as type]
            [normalize.core :refer [normalize]]))

(def base
  [[:html {:overflow-y :scroll}]
   [:body {:background-color :ghostwhite}]
   [:.wrap {:margin [[0 (percent 5)]]}]
   [:.text-wrap {:margin [[ 0 :auto]]
                 :max-width (px 650)}]
   [:hr {:background-color :lightgray
         :border :none
         :height (px 1)
         :margin-top (em 3)
         :margin-bottom (em 3)}]
   [:.bw {:background :black
          :color :white}]
   [:.gw {:background (rgb 50 50 50)
          :color :white}]
   [:.logo {:position :absolute
            :z-index 10
            :width (px 64)}]
   [:.air c/air]
   [:.toned {:color :lightgray}]
   [:.content {:padding c/air}
    [:>img :>video {:width (percent 100)}]]
   [:.cover {:background-size :cover
             :background-position :center
             :background-repeat :no-repeat
             :color :white
             :height (px 300)
             :overflow :hidden
             :position :relative
             :margin-bottom (em 0.5)
             :max-height (px 350)
             :width (percent 100)}
    [:.motivator {:position :absolute
                  :color :white
                  :left (percent 50)
                  :top (percent 50)
                  :max-width (vw 30)
                  :transform "translateX(-40vw) translateY(-50%)"}
     [:h1 {:margin 0}]]]])

(def trumps
  [[:#suiteBarLeft {:background-color (rgb 241 241 243)
                    :color :black}]
   [:.ms-pub-contentLayout {:background-color :transparent}]
   [:.ms-belltown-authenticated
    [:.ms-belltown-searcharea {:padding 0
                               :padding-top (px 15)}]]
   [:.ms-core-navigation {:font-family "Open sans"}]
   [:.ms-breadcrumb-box {:height :auto
                         :padding 0}]
   [:input:focus {:border-color :red}]
   [:#titlerow {:background-color :white
                :height (px 53)}]
   [:#titleAreaBox {:margin [[:auto (percent 5)]]}]
   [:#sideNavBox {:margin 0
                  :width 0}]
   [:.ms-srch-sb>input {:width (px 140)}]
   [:.ms-socialCommentItem {:margin [[(em 1) 0]]
                            :line-height (em 1.5)}
    [:img {:margin-right (em 1)}]]])

(defstyles sharepoint
  [(list
    trumps)])

(defstyles screen
  [(list
    type/styles
    normalize
    base
    trumps
    post/styles
    anim/styles
    menues/styles
    flex/styles
    post/styles)])
