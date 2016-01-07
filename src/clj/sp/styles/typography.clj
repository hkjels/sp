(ns sp.styles.typography
  (:refer-clojure :exclude '[+ - * /])
  (:require [garden.arithmetic :refer [+ - * /]]
            [garden.def :refer [defstyles defrule]]
            [garden.units :refer [percent vw em]]
            [garden.stylesheet :refer [at-import]]
            [sp.styles.config :as c :refer [type-scale]]))

(defrule headings :h1 :h2 :h3)

(defrule subheadings :h4 :h5 :h6)

(defrule links :a)

(defn body-copy
  "Open sans as the default typeface"
  []
  (let [url "https://fonts.googleapis.com/css?family=Open+Sans"]
    [(at-import url)
     [:body :p {:font-family "Open sans"}]]))

(defn scale
  "This makes EM's easier to reason about as one EM will be equivalent to 10px"
  [size]
  [[:html :body {:font-size (percent 62.5)}]
   [:body {:font-size size}]
   [:.golden {:max-width (percent 80)}]
   [:h1.title :p.preface {:color :white}]])

(def headings-copy
  (headings {:font-family [[:Open :Sans]]
             :font-weight c/header-font-weight
             :margin 0
             :max-width (vw 60)}))

(def decorations
  (links {:text-decoration :none}
         [:&:visited {:color :inherit}]
         [:&:hover {:text-decoration :none}]))

(defstyles styles [(conj (body-copy) headings-copy (scale type-scale) decorations)])
