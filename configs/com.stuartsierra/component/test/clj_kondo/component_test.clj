(ns clj-kondo.component-test
  (:require [com.stuartsierra.component :as component]))

(defn ->component [] {})

;; components must be key/value pairs, not a map literal
(component/system-map
 {:foo (->component)
  :bar (->component)})

;; reusing a component key is a smell (later wins)
(component/system-map
 :foo (->component)
 :foo (->component))

;; components can be used out of order
(component/system-map

 ;; raises no error when a key of vector syntax has a matching entry
 :bar (component/using
       (->component)
       [:foo])

 ;; raises no error when a key of map syntax has a matching entry
 :qux (component/using
       (->component)
       {:fooo :foo
        :barr :bar})

 ;; ignores when a component definition doesn't use `component/using`
 :foo (->component)

 ;; raises an error when key of vector syntax has no matching entry
 :vector (component/using
          (->component)
          [:bad-foo])

 ;; raises an error when a val of map syntax has no matching entry
 :map (component/using
       (->component)
       {:foo :bad-foo
        :bar :bad-bar}))
