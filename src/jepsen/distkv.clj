(ns jepsen.distkv
	"Tests for distkv"
  (:require [clojure.tools.logging :refer :all]
            [clojure.core.reducers :as r]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [clojure.pprint :refer [pprint]]
            [knossos.op :as op]
            [jepsen [client :as client]
                    [core :as jepsen]
                    [db :as db]
                    [tests :as tests]
                    [control :as c :refer [|]]
                    [checker :as checker]
                    [nemesis :as nemesis]
                    [generator :as gen]
                    [util :refer [timeout meh]]]
            [jepsen.control.util :as cu]
            [jepsen.control.net :as cn]
            [jepsen.os.ubuntu :as ubuntu]))

(defn db
	"Sets up and tears down distkv"
	[version]
	(reify db/DB
    (setup! [_ test node]
      (info node "set up"))

    (teardown! [_ test node]
      (info node "tore down"))))

(defn noop-test
  "A simple test of distkv's safety."
  [version]
  (assoc tests/noop-test :os ubuntu/os
   						  :db (db version)))

