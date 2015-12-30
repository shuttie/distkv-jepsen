(ns jepsen.distkv-test
  (:require [clojure.test :refer :all]
  			[jepsen.core :refer [run!]]
            [jepsen.distkv :refer :all]))

(def version
	"What meowdb version should we test?"
	"1.2.3")

(deftest basic-test
  (is (:valid? (:results (run! (assoc (noop-test version) :ssh {:strict-host-key-checking false :private-key-path "~/.ssh/grebennikov_roman.pem" :username "root"}))))))
