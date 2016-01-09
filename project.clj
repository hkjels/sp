(defproject sp "0.0.1"
  :dependencies [[com.powernoodle/normalize "0.1.1"]
                 [compojure "1.4.0"]
                 [garden "1.3.0"]
                 [org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170"]
                 [org.clojure/test.check "0.9.0"]
                 [re-frame "0.6.0"]
                 [reagent "0.5.1"]
                 [ring "1.4.0"]
                 [secretary "1.2.3"]]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj"]

  :plugins [[lein-cljsbuild "1.1.1"]
            [lein-figwheel "0.5.0-2"]
            [lein-garden "0.2.6"]]

  :figwheel {:css-dirs ["resources/public/css"]
             :ring-handler sp.handler/handler}

  :garden {:builds [{:id "screen"
                     :source-paths ["src/clj"]
                     :stylesheet sp.css/screen
                     :compiler {:output-to "resources/public/css/compiled/screen.css"
                                :vendors [:moz :webkit :ms]
                                :pretty-print? true}}
                    {:id "sharepoint"
                     :source-paths ["src/clj"]
                     :stylesheet sp.css/sharepoint
                     :compiler {:output-to "resources/public/css/comiled/10mot2020.css"
                                :pretty-print? true}}]}

  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src/cljs"]
                        :figwheel {:on-jsload "sp.core/mount-root"}
                        :compiler {:main sp.core
                                   :output-to "resources/public/js/compiled/app.js"
                                   :output-dir "resources/public/js/compiled/out"
                                   :asset-path "js/compiled/out"
                                   :source-map-timestamp true}}

                       {:id "min"
                        :source-paths ["src/cljs"]
                        :compiler {:main sp.core
                                   :output-to "resources/public/js/compiled/app.js"
                                   :optimizations :advanced
                                   :closure-defines {goog.DEBUG false}
                                   :pretty-print false}}]}

  :clean-targets ^{:protect false} [[:cljsbuild :builds 0 :compiler :output-dir]
                                    [:cljsbuild :builds 0 :compiler :output-to]
                                    [:garden :builds 0 :compiler :output-to]
                                    [:garden :builds 1 :compiler :output-to]
                                    "dev-resources"
                                    "target"])
