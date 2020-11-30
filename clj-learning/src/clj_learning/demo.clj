(require '[clojure.xml :as xml]
         '[clojure.zip :as zip]
         '[cheshire.core :as json]
         )

(use 'cheshire.core)


(xml/parse "src/demo.xml")

(generate-string {:foo "bar" :baz 5})

(def x 1)
(def y x)









