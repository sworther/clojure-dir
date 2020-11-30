(ns http-kit-demo.core
  (:require [org.httpkit.client :as http])
  (:gen-class))

(let [resp1 (http/get "http://http-kit.org/")
      resp2 (http/get "http://clojure.org/")]
  (println "Response 1's status: " (:status @resp1)) ; wait as necessary
  (println "Response 2's status: " (:status @resp2)))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]

  (let [resp1 (http/get "http://http-kit.org/")
        resp2 (http/get "http://clojure.org/")]
    (println "Response 1's status: " (:status @resp1)) ; wait as necessary
    (println "Response 2's status: " (:status @resp2)))


  )
