(ns statute.facts-test
  (:require [kotoba.lang.text :as str]
            [clojure.test :refer [deftest is]]
            [statute.facts :as facts]))

(deftest kgz-has-spec-basis
  (let [sb (facts/spec-basis "KGZ")]
    (is (= 4 (count sb)))
    (is (every? #(str/starts-with? (:statute/url %) "https://") sb))
    (is (every? :statute/law-number sb))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["KGZ" "JPN" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["ATL" "JPN"] (:missing-jurisdictions c)))))

(deftest by-topic-filters
  (is (= ["kgz.labour-code-2025"]
         (mapv :statute/id (facts/by-topic "KGZ" :labor))))
  (is (= ["kgz.investment-law-2025"]
         (mapv :statute/id (facts/by-topic "KGZ" :investment))))
  (is (= ["kgz.tax-code-2022"]
         (mapv :statute/id (facts/by-topic "KGZ" :tax))))
  (is (= ["kgz.public-procurement-law-2022"]
         (mapv :statute/id (facts/by-topic "KGZ" :procurement))))
  (is (empty? (facts/by-topic "KGZ" :environment)))
  (is (empty? (facts/by-topic "ATL" :labor))))
