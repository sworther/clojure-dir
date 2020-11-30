(require '[org.httpkit.client :as http])
(require '[clojure.data.json :as json])


;Send request concurrently, with half the waiting time
(let [resp1 (http/get "http://http-kit.org/")
      resp2 (http/get "http://clojure.org/")]
  (println "Response 1's status: " (:status @resp1)) ; wait as necessary
  (println "Response 2's status: " (:status @resp2)))

;asynchronous with promise, callback
(def options {:timeout 2000             ; ms
              :basic-auth ["user" "pass"]
              :query-params {:param "value" :param2 ["value1" "value2"]}
              :user-agent "User-Agent-string"
              :headers {"X-Header" "Value"}})
(http/get "http://httpbin.org/get" options
          (fn [{:keys [status headers body error]}] ;; asynchronous response handling
            (if error
              (println "Failed, exception is " error)
              (println "Async HTTP GET: " status))))


;; synchronous with @promise
(let [{:keys [status headers body error] :as resp} @(http/get "http://httpbin.org/get")]
  (if error
    (println "Failed, exception: " error)
    (println "HTTP GET success: " status)))



;; Form params
(let [options {:form-params {:name "http-kit" :features ["async" "client" "server"]}}
      {:keys [status error]} @(http/post "http://httpbin.org/get" options)]
  (if error
    (println "Failed, exception is " error)
    (println "Async HTTP POST: " status)))

(defn add-li [x]
  (println "hello"))

(add-li 2)