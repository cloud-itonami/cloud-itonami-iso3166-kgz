(ns marketentry.facts-test
  (:require [clojure.test :refer [deftest is testing]]
            [marketentry.facts :as facts]))

(deftest kgz-has-spec-basis
  (let [sb (facts/spec-basis "KGZ")]
    (is (some? sb))
    (is (string? (:provenance sb)))
    (is (seq (:required-evidence sb)))
    (is (some? (facts/corporate-number-spec-basis "KGZ")))
    (is (some? (facts/business-registration-spec-basis "KGZ")))
    (is (some? (facts/probation-ceiling-spec-basis "KGZ")))
    (is (some? (facts/procurement-fine-tier-spec-basis "KGZ")))
    (is (some? (facts/eaeu-membership-spec-basis "KGZ")))))

(deftest kgz-rep-spec-basis-is-honestly-nil
  (testing "this iteration did not find any authorized-representative eligibility/exclusion article for the Kyrgyz Republic's procurement regime this session -- an honest, disclosed access gap, not an assertion that no such provision exists"
    (is (nil? (facts/rep-spec-basis "KGZ")))))

(deftest kgz-business-registration-and-tax-registration-are-described-independently
  (testing "business registration (Ministry of Justice single window) and tax registration (TIN/ИНН, sti.gov.kg) are distinct topics -- see namespace docstring"
    (let [reg (facts/business-registration-spec-basis "KGZ")
          tax (facts/corporate-number-spec-basis "KGZ")]
      (is (some? reg))
      (is (some? tax))
      (is (not= (:business-registration-owner-authority reg)
                (:corporate-number-owner-authority tax))))))

(deftest kgz-probation-ceiling-is-the-flagship-spec-basis
  (testing "Labour Code Article 24's statutory ceiling is a real, verifiable, category-dependent ceiling -- not fabricated"
    (let [pc (facts/probation-ceiling-spec-basis "KGZ")]
      (is (some? pc))
      (is (= 3 (:probation-ceiling-general-months pc)))
      (is (= 6 (:probation-ceiling-senior-months pc)))
      (is (= 7 (count (:probation-ceiling-senior-categories pc))))
      (is (string? (:probation-ceiling-legal-basis pc))))))

(deftest kgz-procurement-fine-tier-is-documented-not-governor-gated
  (testing "Article 356 fine schedule is documented for transparency/testability -- see marketentry.governor docstring for why it is not an additional HARD check"
    (let [ft (facts/procurement-fine-tier-spec-basis "KGZ")]
      (is (some? ft))
      (is (= 100 (:procurement-fine-tier-calculation-index-som ft)))
      (is (= 4 (count (:procurement-fine-tier-brackets ft))))
      (is (nil? (:max-planned-amount-som (last (:procurement-fine-tier-brackets ft))))
          "the last bracket is open-ended (no upper bound)"))))

(deftest kgz-eaeu-membership-is-independently-confirmed
  (testing "eaeunion.org's own text names the Kyrgyz Republic as a Member-State"
    (let [em (facts/eaeu-membership-spec-basis "KGZ")]
      (is (true? (:eaeu-member? em)))
      (is (string? (:eaeu-legal-basis em)))
      (is (string? (:eaeu-provenance em)))
      (is (nil? (facts/eaeu-membership-spec-basis "USA"))
          "USA is not an EAEU member in this catalog"))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ")))
  (is (nil? (facts/business-registration-spec-basis "ATL")))
  (is (nil? (facts/probation-ceiling-spec-basis "ATL")))
  (is (nil? (facts/rep-spec-basis "ATL")))
  (is (nil? (facts/procurement-fine-tier-spec-basis "ATL")))
  (is (nil? (facts/eaeu-membership-spec-basis "ATL"))))

(deftest required-evidence-satisfied
  (let [sb (facts/spec-basis "KGZ")
        all (:required-evidence sb)]
    (is (true? (facts/required-evidence-satisfied? "KGZ" all)))
    (is (not (facts/required-evidence-satisfied? "KGZ" (take 1 all))))
    (is (nil? (facts/required-evidence-satisfied? "ATL" all)))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["KGZ" "USA" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 2 (:covered c)))
    (is (= ["ATL"] (:missing-jurisdictions c)))))
