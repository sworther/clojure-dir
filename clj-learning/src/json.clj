(require '[clojure.xml :as xml]
         '[clojure.zip :as zip]
         '[cheshire.core :as json]
         )

(use 'cheshire.core)
(json/parse-string "{\"foo\":\"bar\"}")

(parse-string "{\"foo\":\"bar\"}")