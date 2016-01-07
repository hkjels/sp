(ns sp.handler
  (:require [compojure.core :refer [GET defroutes]]
            [ring.util.response :refer [file-response resource-response]]
            [ring.middleware.content-type :refer [wrap-content-type]]))

(defroutes handler
  (GET "/" [] (wrap-content-type (file-response "index.html" {:root "resources/public"})))
  (GET "/videos/:video" [video] (resource-response video {:root "resources/public/videos"})))
