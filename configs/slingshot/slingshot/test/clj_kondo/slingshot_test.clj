(ns clj-kondo.slingshot-test
  (:require [slingshot.slingshot :refer [throw+ try+]]))

(defn read-file [file]
  (try+
   (prn file)
   (catch [:type :tensor.parse/bad-tree] {:keys [tree hint]}
     (prn tree hint)
     (throw+))
   (catch (= 504 (-> % :status)) (+ 1 2 3))
   (catch Object _
     (throw+))))
