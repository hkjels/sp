(ns sp.styles.menues
  (:refer-clojure :exclude '[+ - * /])
  (:require [garden.arithmetic :refer [+ - * /]]
            [garden.def :refer [defstyles defkeyframes]]
            [garden.color :refer [rgba rgb]]
            [garden.selectors :refer [defselector defpseudoclass defpseudoelement attr attr=]]
            [garden.units :refer [percent vw em px]]
            [sp.styles.flex :as flex]
            [sp.styles.post :as post]
            [sp.styles.config :as c :refer [red]]
            [sp.styles.typography :as type]))

(def top-menu
  [:.top-menu :.bottom-menu {:box-sizing :border-box
                             :font-size (em 0.7)
                             :padding (em 1)
                             :text-align :right
                             :width (percent 100)}
   [:a
    [:&:hover {:text-decoration :none}]
    [:&:visited {:color :inherit}]]])

(def main-menu
  [:.main-menu :.ms-core-listMenu-root {:box-sizing :border-box
                                        :color :black
                                        :display :inline-block
                                        :font-weight 600
                                        :margin-left (px 64)
                                        :text-transform :uppercase}
   [:.ms-listMenu-editLink {:vertical-align [[:middle :!important]]}
    [:.ms-metadata {:font-family "Open sans"
                    :font-size (em 0.7)}]]
   [:li {:border-right [[(px 1) :solid :ghostwhite]]}
    [:&:first-child {:border-left [[(px 1) :solid :ghostwhite]]}]]
   [:a :.ms-core-listMenu-item {:border :none
                                :border-bottom-width [[(px 2) :!important]]
                                :border-bottom-style :solid
                                :border-bottom-color :transparent
                                :color :black
                                :padding (em 1)
                                :margin-right [[0 :!important]]
                                :min-width (vw 10)
                                :text-align :center}
    [:&:hover
     [:span {:color :black}]]
    [:&.active :&.selected.ms-core-listMenu-selected :&.selected.ms-core-listMenu-selected:hover {:background-color :ghostwhite
                                                                                                  :border-bottom-color :red}
     [:span {:color :black}]]]])

(def textfield
  [:.ms-socialCommentInputBoxBorder {:border-width (px 2)
                                     :outline :none
                                     :border-color (rgb 56 71 79)}
   [:&:focus {:border-color red}]])

(def button
  ["input[type=button]" {:padding [[(em 1) (em 2)]]
                          :background-color :white
                          :overflow :hidden
                          :border [[(px 2) :solid (rgb 56 71 79)]]
                          :color (rgb 56 71 79)
                          :font-weight 600
                          :text-transform :uppercase
                          :min-width (px 150)
                          :max-width (px 250)
                          :margin [[(em 1) 0]]
                          :transition [[".3s" :ease]]
                          :vertical-align :middle}
   [:&:hover {:background-color red
              :border-color red
              :color :white}]])

(def shared
  [[:header {:background-color :white}
    [:.wrap {:position :relative}]]
   [:menu {:margin 0
           :padding 0}
    [:a {:box-sizing :border-box
         :color :inherit
         :display :inline-block
         :padding [[0 (em 1)]]
         :text-decoration :none}]]])

(defstyles styles [(conj shared textfield button top-menu main-menu)])
