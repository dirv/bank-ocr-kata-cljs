(ns bank-ocr-kata.ocr-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [bank-ocr-kata.ocr :as ocr]))

(deftest read-single-character
  (testing "reads a 1"
    (is (= 1 (ocr/read-single-character "???")))))
