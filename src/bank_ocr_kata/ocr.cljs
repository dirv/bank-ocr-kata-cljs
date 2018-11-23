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
  (let [[top middle bottom] (clojure.string/split s #"\n")
        top-chs (partition-strs 3 top)
        middle-chs (partition-strs 3 middle)
        bottom-chs (partition-strs 3 bottom)
        character-strings (map #(str %1 %2 %3) top-chs middle-chs bottom-chs)]
    (apply str (map read-single-character character-strings))))
