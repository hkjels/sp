(ns sp.styles.animation
  (:refer-clojure :exclude '[+ - * /])
  (:require [garden.arithmetic :refer [+ - * /]]
            [garden.def :refer [defstyles defkeyframes]]
            [garden.units :refer [percent vw em px]]))

(def animated
  [:.animated {:animation-fill-mode :both
               :animation-iteration-count 1
               :animation-duration "1s"
               :transform "translateZ(0)"}
   [:&.pulse {:animation-direction :alternate}]
   [:&.infinite {:animation-iteration-count :infinite}]])

(defkeyframes fadeIn
  [:from {:opacity 0}]
  [:to {:opacity 1}])

(defkeyframes fadeOut
  [:from {:opacity 1}]
  [:to {:opacity 0}])

(defkeyframes moveUp
  [:from {:transform "translateY(100%)"}]
  [:to {:transform :none}])

(defkeyframes moveDown
  [:from {:transform "translateY(-100%)"}]
  [:to {:transform :none}])

(defkeyframes moveLeft
  [:from {:transform "translateX(100%)"}]
  [:to {:transform :none}])

(defkeyframes moveRight
  [:from {:transform "translateY(-100%)"}]
  [:to {:transform :none}])

(def animations
  [[animated]
   [fadeIn]
   [fadeOut]
   [moveUp]
   [moveDown]
   [moveLeft]
   [moveRight]
   [:.fadeIn ^:prefix {:animation-name :fadeIn}]
   [:.fadeOut ^:prefix {:animation-name :fadeOut}]
   [:.moveUp ^:prefix {:animation-name :moveUp}]
   [:.moveDown ^:prefix {:animation-name :moveDown}]
   [:.moveLeft ^:prefix {:animation-name :moveLeft}]
   [:.moveRight ^:prefix {:animation-name :moveRight}]
   [:.fadeInUp ^:prefix {:animation [:fadeIn :moveUp]}]
   [:.fadeInDown ^:prefix {:animation [:fadeIn :moveDown]}]
   [:.fadeInLeft ^:prefix {:animation [:fadeIn :moveLeft]}]
   [:.fadeInRight ^:prefix {:animation [:fadeIn :moveRight]}]
   [:.fadeOutUp ^:prefix {:animation [:fadeOut :moveUp]}]
   [:.fadeOutDown ^:prefix {:animation [:fadeOut :moveDown]}]
   [:.fadeOutLeft ^:prefix {:animation [:fadeOut :moveLeft]}]
   [:.fadeOutRight ^:prefix {:animation [:fadeOut :moveRight]}]])

(defstyles styles [animations])
