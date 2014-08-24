(defproject scrape "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/tools.reader "0.8.7"]

                 ;; scraping
                 [clj-webdriver "0.6.1"]
                 [co.uk.egao/enlive "1.1.5"]
                 [org.clojure/core.async "0.1.267.0-0d7780-alpha"]
                 [rdfa "0.5.1-SNAPSHOT"
                  :exclusions [xml-apis/xml-apis
                               xerces/xercesImpl]]

                 ;; Database model
                 [org.clojure/java.jdbc "0.3.5"]
                 [korma "0.3.4-SNAPSHOT"]
                 [naan "0.1.0-SNAPSHOT"]
                 ;; JDBC
                 [com.h2database/h2 "1.4.181"]
                 [org.postgresql/postgresql "9.3-1101-jdbc41"]

                 ;; repl
                 [cider/cider-nrepl "0.8.0-SNAPSHOT"]
                 [compliment "0.1.3"]
                 [org.clojure/tools.trace "0.7.8"]
                 [org.clojure/tools.logging "0.3.0"]]

  :jvm-opts ["-Dphantomjs.binary.path=C:\\work\\phantomjs\\bin\\phantomjs.exe"]

  :plugins [[lein-ancient "0.5.5"]
            [lein-pdo "0.1.1"]
            [cider/cider-nrepl "0.8.0-SNAPSHOT"]]

  :repl-options {:nrepl-middleware
                  [cider.nrepl.middleware.classpath/wrap-classpath
                   cider.nrepl.middleware.complete/wrap-complete
                   cider.nrepl.middleware.info/wrap-info
                   cider.nrepl.middleware.inspect/wrap-inspect
                   cider.nrepl.middleware.macroexpand/wrap-macroexpand
                   cider.nrepl.middleware.stacktrace/wrap-stacktrace
                   cider.nrepl.middleware.trace/wrap-trace]}
  )
