(ns bank-ocr-kata.ocr-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [bank-ocr-kata.ocr :as ocr]))

(deftest read-single-character
  (testing "reads a 0"
    (is (= 0 (ocr/read-single-character (nth ocr/characters 0))))))

(comment (def full-set
           (str " _     _  _     _  _  _  _ \n"
                "| |  | _| _||_||_ |_   ||_|\n"
                "|_|  ||_  _|  | _||_|  ||_|\n")))
