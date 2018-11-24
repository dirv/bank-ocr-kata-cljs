(ns bank-ocr-kata.core
  (:require [bank-ocr-kata.ocr :as ocr]
            [reagent.core :as r]))

(defn vertical-line [x y1 y2]
  [:line {:x1 x :y1 y1 :x2 x :y2 y2 :stroke "grey" :strokeWidth 2}])

(defn horizontal-line [x1 x2 y]
  [:line {:x1 x1 :y1 y :x2 x2 :y2 y :stroke "grey" :strokeWidth 2}])

(defn single-digit [position width height padding]
  (let [box-width (/ width 3)
        box-height (/ height 3)
        box-half-width ( / box-width 2)
        x-start (+ (* (+ width padding) position))]
    [:svg [horizontal-line (+ x-start box-width)
                      (+ x-start box-width box-width)
                      box-height]
     [vertical-line (+ x-start box-half-width)
                    box-height
                    (* box-height 2)]
     [horizontal-line (+ x-start box-width)
                      (+ x-start box-width box-width)
                      (+ box-height box-height)]
     [vertical-line (+ x-start box-width box-width box-half-width)
                    box-height
                    (* box-height 2)]
     [vertical-line (+ x-start box-half-width)
                    (* box-height 2)
                    (* box-height 3)]
     [horizontal-line (+ x-start box-width)
                      (+ x-start box-width box-width)
                      (+ box-height box-height box-height)]
     [vertical-line (+ x-start box-width box-width box-half-width)
                    (* box-height 2)
                    (* box-height 3)]]))

(defn all-digits [number]
  [:svg {:width (* 60 10) :height 100}
   (for [digit (range 0 9)]
     ^{:key digit} [single-digit digit 50 80 10])])

(defn ^:export run [container]
  (r/render [all-digits "012345678"]
            container))
