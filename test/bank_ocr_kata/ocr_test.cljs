(ns bank-ocr-kata.ocr-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [bank-ocr-kata.ocr :as ocr]))

(deftest read-single-character
  (testing "reads a 0"
    (is (= 0 (ocr/read-single-character (nth ocr/characters 0)))))
  (testing "reads a 1"
    (is (= 1 (ocr/read-single-character (nth ocr/characters 1)))))
  (testing "reads a 2"
    (is (= 2 (ocr/read-single-character (nth ocr/characters 2)))))
  (testing "reads a 3"
    (is (= 3 (ocr/read-single-character (nth ocr/characters 3)))))
  (testing "reads a 4"
    (is (= 4 (ocr/read-single-character (nth ocr/characters 4)))))
  (testing "reads a 5"
    (is (= 5 (ocr/read-single-character (nth ocr/characters 5)))))
  (testing "reads a 6"
    (is (= 6 (ocr/read-single-character (nth ocr/characters 6)))))
  (testing "reads a 7"
    (is (= 7 (ocr/read-single-character (nth ocr/characters 7)))))
  (testing "reads a 8"
    (is (= 8 (ocr/read-single-character (nth ocr/characters 8)))))
  (testing "reads a 9"
    (is (= 9 (ocr/read-single-character (nth ocr/characters 9))))))

(deftest read-many-characters
  (testing "reads 10"
    (is (= "10" (ocr/read-many (str "    _ \n"
                                    "  || |\n"
                                    "  ||_|\n")))))
  (testing "reads 012345678"
    (is (= "012345678" (ocr/read-many (str " _     _  _     _  _  _  _ \n"
                                           "| |  | _| _||_||_ |_   ||_|\n"
                                           "|_|  ||_  _|  | _||_|  ||_|\n"))))))
