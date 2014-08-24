(ns scrape.core
  (:require [clj-webdriver.taxi :refer :all]
            [net.cgrand.enlive-html :as e]
            [clj-webdriver.driver :refer [init-driver]]
            [rdfa core parser cli])
  (:import (org.openqa.selenium.phantomjs PhantomJSDriver)
           (org.openqa.selenium.remote DesiredCapabilities)
           (java.io StringReader)))

(defn create-driver [] (init-driver
                         {:webdriver
                           (PhantomJSDriver. (doto (DesiredCapabilities.)
                                               (.setCapability "phantomjs.page.settings.userAgent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.143 Safari/537.36")
                                               (.setCapability "phantomjs.page.customHeaders.Accept-Language" "en-US")
                                               (.setCapability "phantomjs.page.customHeaders.Connection" "keep-alive")
                                               (.setCapability "phantomjs.cli.args" (into-array String ["--ignore-ssl-errors=true"
                                                                                                        "--webdriver-loglevel=WARN"]))))}))

(defonce phantom (create-driver))

(set-driver! phantom)

(defn as-rdfa
  ([q]
   (as-rdfa clj-webdriver.taxi/*driver* q))
  ([driver q]
   (rdfa.parser/get-rdfa
     (StringReader.
       (html driver q)) (current-url driver) :html)))
