

(def directory (clojure.java.io/file "."))
(def files (file-seq directory))
(take 10 files)