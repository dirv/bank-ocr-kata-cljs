(ns bank-ocr-kata.ocr
  (:require [clojure.string]))

(def characters
  [(str " _ "
        "| |"
        "|_|")

   (str "   "
        "  |"
        "  |")

   (str " _ "
        " _|"
        "|_ ")

   (str " _ "
        " _|"
        " _|")

   (str "   "
        "|_|"
        "  |")

   (str " _ "
        "|_ "
        " _|")

   (str " _ "
        "|_ "
        "|_|")

   (str " _ "
        "  |"
        "  |")

   (str " _ "
        "|_|"
        "|_|")

   (str " _ "
        "|_|"
        " _|")
   ])

(defn read-single-character [s]
  (.indexOf characters s))

(defn partition-strs [n s]
  (map #(apply str %) (partition n s)))

(defn read-many [s]
  (->> (clojure.string/split s #"\n")
       (map #(partition-strs 3 %))
       (apply map #(str %1 %2 %3))
       (map read-single-character)
       (apply str)))
