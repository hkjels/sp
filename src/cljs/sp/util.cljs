(ns sp.util
  (:require [clojure.string :refer [lower-case replace join]]))

(defn slug-encode [text]
  (let [prepared (-> (str text)
                     (lower-case)
                     (replace #"&" "-")
                     (replace  #"\s" "-")
                     (replace #"[-]{2,}" "-"))]
    (js/encodeURIComponent prepared)))

(defn ipsum []
  (let [ipsum-text (join ["From this day forward, Flight Control will be known "
                          "by two words: 'Tough' and 'Competent.' Tough means "
                          "we are forever accountable for what we do or what "
                          "we fail to do. We will never again compromise our "
                          "responsibilities. Every time we walk into Mission "
                          "Control we will know what we stand for. Competent "
                          "means we will never take anything for granted. We "
                          "will never be found short in our knowledge and in "
                          "our skills. Mission Control will be perfect. When "
                          "you leave this meeting today you will go to your office "
                          "and the first thing you will do there is to write "
                          "Tough and Competent' on your blackboards. It will "
                          "never be erased. Each day when you enter the room "
                          "these words will remind you of the price paid by Grisso "
                          ", White, and Chaffee. These words are the price of "
                          "admission to the ranks of Mission Control. "])]
    (subs ipsum-text 0 (rand-int (count ipsum-text)))))

(defn a-comment [parent]
  {:id 1000
   :parent parent
   :by 100
   :comment (ipsum)})

