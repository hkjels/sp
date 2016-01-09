(ns sp.views
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [reagent.core :refer [atom create-class]]
            [sp.util :refer [slug-encode ipsum]]
            [re-frame.core :refer [subscribe]]
            [goog.events :as events]
            [goog.dom :as dom]
            [clojure.string :refer [join]]))

(def wow (js/WOW.))

(defn comment-panel [comment]
  [:p (:comment comment)])

(defn comments-panel [id]
  (let [comments (subscribe [:comments id])]
    (fn []
      [:form
       [:hr]
       [:h3 "Comments"]
       [:ul (map comment-panel @comments)]])))

(defn video-source [video]
  (let [{:keys [url type]} video]
    ^{:key url} [:source {:src url :type type}]))

(defn post-panel [post]
  (let [{:keys [id uri title preface body photo video]} post]
    [:div.post
     [:video {:controls (when video true)
              :preload true
              :poster ""
              :style {:background-image (str "url(" photo ")")}}
      (map video-source video)]
     [:div.text-wrap
      [:h1 title]
      [:h4 preface]
      [:p body]
      [(comments-panel id)]]]))

(defn post-intro-panel [post]
  (let [{:keys [id uri title preface photo video location]} post
        slug (slug-encode title)]
    ^{:key id} [:a.post-intro {:href (str "#/ambitions/" slug)}
                (when location [:div.location location])
                [:figure.photo
                 [:img {:src photo}]
                 (when video [:i.icon.ion-ios-play])]
                [:div.content
                 [:h4.title title]
                 [:small "Skrevet: av Fornavn Etternavn"]
                 [:p preface]]]))

(defn posts-grid-list [ref]
  (let [posts (subscribe [ref])]
    (fn []
      [:ul.posts-grid.layout.layout-wrap.stretch-center {:class ref}
       (map post-intro-panel @posts)])))

(defn menu-item [{:keys [id uri text active?]} item]
  ^{:key id} [:a {:href uri :class (when active? "active")} text])

(defn menu [ref]
  (let [items (subscribe [ref])]
    (fn []
      [:menu {:class ref}
       (map menu-item @items)])))

(defn header []
  [:header
   [:div.bw
    [:div.wrap
     [:a {:href "/"} [:img.logo {:src "/images/logo.png"}]]
     [menu :top-menu]]]
   [:div.wrap.flex.space-between
    [menu :main-menu]
    [:input {:type :search :name :query :placeholder :search}]]])


;; about

(defn about-panel []
  (create-class
   {:component-did-mount #(.init wow)
    :reagent-render (fn []
                      [:div
                       [:div.content.gw
                        [:div.text-wrap
                         [:h3 "Hvorfor 10 mot 2020?"]
                         [:p (join ["BDO har vokst mye de siste årene og går nå inn i en spennende tid."
                                    "Vi er per i dag størst på revisjon, og vokser stadig i alle andre felt."
                                    "Vi ønsker å skape de beste kundeopplevelsene, gjennom å utforde, utvikle talent, skape verdier og vokse."
                                    "Ledelsen har over lengre tid jobbet fram 10 strategiske ambisjoner som skal sikre videre fremtidig vekst:"
                                    "\"10 mot 2020\"."
                                    "Strategiene er utviklet med utgangspunkt i markedsinnsikt, dagens posisjon, prestasjoner og fremtidige målsetninger."
                                    "Hver ambisjon har sin dedikerte sponsor som er ansvarlig for hver ambisjon."])]] ]
                       [:div.text-wrap
                        (map (fn [txt] [:p.wow.fadeInUp txt]) (repeatedly 100 #(ipsum)))]])}))


;; ambitions

(defn ambitions-panel []
  (fn []
    [:div
     [:div.cover {:style {:background-image "url(/images/ambition-8.jpg)"}}
      [:div.motivator
       [:h1 "HR"]
       [:p (join ["Vi skal være et flott sted å arbeide for engasjerte, motiverte"
                  "og kompetente medarbeidere og partnere."])]]]
     [:div.wrap
      [posts-grid-list :ambitions]]]))

(defn ambitions-post-panel []
  (let [ambition (subscribe [:ambition])]
    (fn []
      [:div
       [post-panel @ambition]])))


;; relay

(defn relay-panel []
  (fn []
    [:div.wrap [:h3 "Relay race"]]))


;; talk

(defn talk-panel []
  (fn []
    [:div.wrap [:h3 "Talk"]]))


;; status

(defn status-panel []
  (fn []
    [:div.wrap [:h3 "Status"]]))


;; main

(defmulti panels identity)
(defmethod panels :about-panel [] [about-panel])
(defmethod panels :ambitions-panel [] [ambitions-panel])
(defmethod panels :ambitions-post-panel [] [ambitions-post-panel])
(defmethod panels :relay-panel [] [relay-panel])
(defmethod panels :talk-panel [] [talk-panel])
(defmethod panels :status-panel [] [status-panel])
(defmethod panels :default [] [:div])

(defn main-panel []
  (let [active-panel (subscribe [:active-panel])]
    (fn []
      [:div
       [header]
       [:div (panels @active-panel)]])))
