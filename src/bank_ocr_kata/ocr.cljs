(ns bank-ocr-kata.ocr
  (:require [clojure.string]))

(def characters
  [(str " _ "
        "| |"
        "|_|")
   ])

(defn read-single-character [s]
  (when (= s (nth characters 0))
    0))
