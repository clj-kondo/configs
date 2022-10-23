(ns test
  (:require [taoensso.nippy :as nippy])
  (:import [java.io File]))

(nippy/extend-freeze
 File :my-type/foo ; A unique (namespaced) type identifier
 [x data-output]
 (.writeUTF data-output (:data x)))

(nippy/extend-thaw
 :my-type/foo ; Same type id
 [data-input]
 (MyType. data-input))
