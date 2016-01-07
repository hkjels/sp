(ns sp.db
  (:require [clojure.test.check.generators :as gen]
            [sp.util :refer [ipsum]]))

(def hostname (.-hostname js/location))

(def default-db
  {:top-menu [{:id 1 :uri "#/exact" :text "Exact"}
              {:id 2 :uri "#/contact" :text "Contact"}]
   :main-menu [{:id 3 :panel :about-panel :uri "/" :text "About"}
               {:id 4 :panel :ambitions-panel :uri "#/ambitions" :text "Strategic ambitions" :active? true}
               ;; {:id 5 :panel :relay-panel :uri "#/relay" :text "Relay race"}
               ;; {:id 6 :panel :talk-panel :uri "#/talk" :text "Talk"}
               ;; {:id 7 :panel :status-panel :uri "#/status" :text "Status"}
               ]
   :bottom-menu [{:id 8 :uri "#top" :text "To the top"}]
   :contacts [{:id 100
               :name "Henrik Kjerringvåg"
               :photo ""}]
   :ambitions [{:id 9
                :title "Gode kundeopplevelser"
                :preface "Vi skal gjennom relevante og verdifulle leveranser med høy kvalitet gi bransjens beste kundeopplevelser."
                :body (ipsum)
                :photo "/images/ambition-1.jpg"
                :last-modified "Thu Dec 17 12:45:34 CET 2015"
                :author 100}
               {:id 10
                :title "Innovasjon"
                :preface "Vi skal gjennom innovative løsninger og tankegang differensiere oss ved å utfordre etablerte bransjestandarder."
                :body (ipsum)
                :photo "/images/typer.jpg"
                :video [{:url (str "http://" hostname ":3000/videos/typer.mp4")
                         :type "video/mp4;codecs='avc1.42E01E, mp4a.40.2'"}
                        {:url (str "http://" hostname ":3000/videos/typer.ogv")
                         :type "video/ogv;codecs='vobis'"}
                        {:url (str "http://" hostname ":3000/videos/typer.webm")
                         :type "video/webm;codecs='vp8, vorbis'"}]
                :last-modified "Thu Dec 17 12:45:34 CET 2015"
                :location "Drammen"
                :author 100}
               {:id 11
                :title "HR"
                :preface "Vi skal være et flott sted å arbeide for engasjerte, motiverte og kompetente."
                :body (ipsum)
                :photo "/images/ambition-2.jpg"
                :last-modified "Thu Dec 17 12:45:34 CET 2015"
                :author 100}
               {:id 12
                :title "Investering & inntjening"
                :preface "Vi skal sikre robust investeringskraft gjennom solid inntjening."
                :body (ipsum)
                :photo "/images/ambition-3.jpg"
                :last-modified "Thu Dec 17 12:45:34 CET 2015"
                :author 100}
               {:id 13
                :title "Posisjonering"
                :preface "Vi skal tydelig posisjonere oss i utvalgte bransjer og kundesegmenter."
                :body (ipsum)
                :photo "/images/ambition-4.jpg"
                :last-modified "Thu Dec 17 12:45:34 CET 2015"
                :author 100}]})
