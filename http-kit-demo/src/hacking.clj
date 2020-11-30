(require '[org.httpkit.client :as http])


(let [resp1 (http/get "http://http-kit.org/")
      resp2 (http/get "http://clojure.org/")]
  (println "Response 1's status: " (:status @resp1)) ; wait as necessary
  (println "Response 2's status: " (:status @resp2)))