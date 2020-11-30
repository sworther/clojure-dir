(require '[honeysql.core :as sql]
         '[honeysql.helpers :refer :all :as helpers])

(def sqlmap {:select [:a :b :c]
             :from   [:foo]
             :where  [:= :f.a "baz"]})

(sql/format sqlmap)