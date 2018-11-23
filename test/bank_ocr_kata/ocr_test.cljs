(ns bank-ocr-kata.ocr-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [bank-ocr-kata.ocr :as ocr]))

(deftest read-single-character
  (doseq [ch (range 0 10)]
    (testing (str "reads a " ch)
      (is (= ch (ocr/read-single-character (nth ocr/characters ch)))))))

(deftest read-many-characters
  (testing "reads 10"
    (is (= "10" (ocr/read-many (str "    _ \n"
                                    "  || |\n"
                                    "  ||_|\n")))))
  (testing "reads 012345678"
    (is (= "012345678" (ocr/read-many (str " _     _  _     _  _  _  _ \n"
                                           "| |  | _| _||_||_ |_   ||_|\n"
                                           "|_|  ||_  _|  | _||_|  ||_|\n"))))))
