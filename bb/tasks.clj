(ns tasks
  (:require [babashka.fs :as fs]
            [clojure.edn :as edn]))

#_(defn gen-foo [_]
  (let [dirs (map str (fs/glob "." "*/*"))]
    (for [dir dirs]
      (let [deps.edn (slurp (fs/file dir "deps.edn"))
            deps.edn (edn/read-string deps.edn)
            project (-> deps.edn :aliases :neil :project)
            pname (:name project)
            version (:version project)]
        [pname version]))))
