(ns bank-ocr-kata.core-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [jsdom]
            [spy.core :as spy]
            [bank-ocr-kata.core :as core]))

(enable-console-print!)

(defn- create-dom [] (jsdom/JSDOM.))

(defn- multi-call-stub [& args]
  (let [remaining-args (atom args)]
    (spy/mock (fn []
                (if (= 1 (count @remaining-args))
                  (first @remaining-args)
                  (let [this-arg (first @remaining-args)]
                    (swap! remaining-args rest)
                    this-arg))))))

(defn- build-document []
  (-> (create-dom) (.-window) (.-document)))

(defn- build-element [element-type document]
  (let [element (.createElement document element-type)]
    (.appendChild (.-body document) element)
    element))

(defn- raise-event [element event-name]
  (let [document (.-ownerDocument element)
        evt (.createEvent document "HTMLEvents")]
    (.initEvent evt event-name false true)
    (.dispatchEvent element evt)))

(defn- click [input-element]
  (raise-event input-element "click"))

(defn- find-text-box [container]
  (.querySelector container "input[type='text']"))

(defn- find-search-button [container]
  (.querySelector container "input[type='button']"))

(comment (deftest something
  (testing "something"
    (let [spy (spy/stub :find-fn)]
      (with-redefs []
        (is (spy/called? spy))
        (is (spy/called-with? spy [1 2 3])))))))
