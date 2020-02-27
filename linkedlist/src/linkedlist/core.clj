(ns linkedlist.core
	(:require [clojure.java.io :as io])
	(:import (java.io DataOutputStream
		ByteArrayOutputStream)))

; A simple mutable linked list
(deftype MutableLinkedList [value net]
	clojure.lang.Seqable
	(seq [_]
		(lazy-seq (cons value (seq @next)))))

(defn node [value]
	(MutableLinkedList. value (atom nil)))

(defn link! [node next]
	(reset! (.next node) next)
	next)


