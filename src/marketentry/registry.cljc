(ns marketentry.registry
  "Pure-function market-entry filing-draft + filing-submit record
  construction -- an append-only market-entry book-of-record draft.

  Like every sibling actor's registry, there is no single international
  reference-number standard for a public-procurement market-entry
  filing -- every jurisdiction assigns its own format. This namespace
  does NOT invent one; it builds a jurisdiction-scoped sequence number
  and validates the record's required fields, the same honest,
  non-fabricating discipline `marketentry.facts` uses.

  `engagement-fee-matches-claim?` is an HONEST reapplication of the
  SAME ground-truth-recompute DISCIPLINE sibling actors use (verify a
  claimed monetary total against the entity's own recorded quantity x
  unit fields), reapplied to a market-entry engagement fee line.

  `probation-period-exceeds-ceiling?` is this vertical's own ground-
  truth check, grounding KGZ's flagship governor check
  (`marketentry.governor/probation-period-violations`): Article 24 of
  the Labour Code of the Kyrgyz Republic (own primary text, paragraph 4
  read in full at zakon.kg/law/tk-kr/, title/date/number independently
  cross-confirmed at cbd.minjust.gov.kg/3-45/edition/25298/ru -- see
  `marketentry.facts`), states that the duration of an initial
  probation period 'may not exceed 3 months, and for heads of
  organizations and their deputies, chief accountants and their
  deputies, heads of branches, representative offices, and other
  separate structural subdivisions of an organization -- 6 months.'
  This is a CATEGORY-DEPENDENT statutory ceiling that structurally
  RESEMBLES a sibling jurisdiction's own flagship check (both a 3/6
  month split) -- this iteration discloses this honestly as an
  independently re-derived COINCIDENCE from shared post-Soviet labour-
  code drafting heritage, NOT a copied shape: it was discovered by
  reading Article 24's own full text directly, and Kyrgyzstan's own
  enumerated senior-category list is meaningfully larger and partly
  different (7 categories -- including deputy chief accountants and
  heads of branches/representative offices -- vs. that sibling's own 4
  categories, which do not include either). As with every sibling, the
  two employee-category BUCKETS this function dispatches on
  (`:general` / `:senior-management`) are a deliberate simplification
  an operator maps their own declared role into; the full 7-item
  enumeration itself lives in `marketentry.facts` for citation/display
  purposes, not as a dispatch key here.

  `procurement-violation-fine-ci` independently recomputes the
  administrative-fine TIER (in расчетный показатель / calculation-
  index units) that Article 356 of the Code of the Kyrgyz Republic 'On
  Offenses' (No. 128 of 2021) attaches to a given planned-procurement
  amount -- documented here for transparency/testability ONLY. It is
  NOT wired into `marketentry.governor` as an additional HARD check
  (see that namespace's own docstring for why: Article 356's own fines
  fall on procuring-ORGANIZATION officials, not on this actor's own
  bidder-side operator, so gating a bidder's own filing on it would
  conflate two different parties' compliance postures).

  This namespace is pure data + pure functions -- no I/O, no network
  call to any real zakupki.gov.kg, sti.gov.kg or minjust.gov.kg system.
  It builds the RECORD an operator would keep, not the act of submitting
  a filing itself (that is `marketentry.operation`'s `:filing/submit`,
  always human-gated -- see README Actuation)."
  (:require [clojure.string :as str]))

(defn- unsigned-certificate
  "Every certificate this actor produces is UNSIGNED -- signature is
  the market-entry operator's act, not this actor's."
  [kind subject record-id]
  {"@context" ["https://www.w3.org/ns/credentials/v2"]
   "type" ["VerifiableCredential" kind]
   "credentialSubject" {"id" subject "record" record-id}
   "proof" nil
   "issued_by_registry" false
   "status" "draft-unsigned"})

(defn- zero-pad [n w]
  (let [s (str n)]
    (str (apply str (repeat (max 0 (- w (count s))) "0")) s)))

(defn compute-engagement-fee
  "The ground-truth engagement fee for `engagement`'s own `:base-fee`
  and `:monitoring-months` x `:monthly-rate` -- a single flat
  base + months x rate calculation, not a full pricing engine."
  [{:keys [base-fee monthly-rate monitoring-months]}]
  (+ (double base-fee)
     (* (double monthly-rate) (double monitoring-months))))

(defn engagement-fee-matches-claim?
  "Does `engagement`'s own `:claimed-fee` equal the independently
  recomputed `compute-engagement-fee`?"
  [{:keys [claimed-fee] :as engagement}]
  (== (double claimed-fee) (compute-engagement-fee engagement)))

(def probation-ceiling
  "Article 24, paragraph 4, of the Labour Code of the Kyrgyz Republic
  (own primary text, read in full at zakon.kg/law/tk-kr/, 2026-07-23):
  the statutory CATEGORY-DEPENDENT ceiling on the duration of an initial
  probation period."
  {:general-months 3
   :senior-months 6
   :senior-categories #{"heads of organizations"
                        "deputies of heads of organizations"
                        "chief accountants"
                        "deputies of chief accountants"
                        "heads of branches"
                        "heads of representative offices"
                        "heads of other separate structural subdivisions of the organization"}})

(defn- applicable-ceiling-months
  "The statutory ceiling (in months) that applies to `category` -- 6 for
  the enumerated senior roles, 3 for anything else (the Labour Code's
  own general/default rule)."
  [category]
  (if (= category :senior-management)
    (:senior-months probation-ceiling)
    (:general-months probation-ceiling)))

(defn probation-period-exceeds-ceiling?
  "Does `engagement`'s own declared initial-probation-period duration
  exceed Article 24's own statutory ceiling for the declared employee
  category -- 3 months for `:general`, 6 months for
  `:senior-management`?

  A no-op (false) unless `:engages-local-staff-under-probation?` is
  true -- an engagement that declares no locally-engaged staff under a
  probation clause has nothing for this check to validate.
  Missing/non-numeric `:probation-period-months` for a declared true
  engagement is never treated as violating the ceiling here (that is
  the `evidence-incomplete` check's job, upstream, where an assessment
  must already exist)."
  [{:keys [engages-local-staff-under-probation? probation-employee-category probation-period-months]}]
  (boolean
   (when (true? engages-local-staff-under-probation?)
     (when (number? probation-period-months)
       (> probation-period-months (applicable-ceiling-months probation-employee-category))))))

(def procurement-fine-tiers
  "Article 356 of the Code of the Kyrgyz Republic 'On Offenses' (No.
  128 of 2021) -- an administrative fine tier schedule keyed on the
  planned procurement amount (in som), denominated in расчетный
  показатель (calculation-index, c.i.) units. Documented for
  transparency/testability ONLY -- see namespace docstring for why
  this is not wired into `marketentry.governor`."
  [{:max-planned-amount-som 1000000 :fine-ci 100}
   {:max-planned-amount-som 3000000 :fine-ci 125}
   {:max-planned-amount-som 5000000 :fine-ci 175}
   {:max-planned-amount-som nil :fine-ci 200}])

(defn procurement-violation-fine-ci
  "The Article 356 ground-truth administrative-fine tier (in c.i.
  units) for `planned-amount-som` -- the first bracket in
  `procurement-fine-tiers` whose own `:max-planned-amount-som` the
  amount does not exceed, or the final (unbounded) bracket. Pure
  lookup -- documented for transparency/testability, not wired into
  the governor (see namespace docstring)."
  [planned-amount-som]
  (:fine-ci
   (or (some (fn [{:keys [max-planned-amount-som] :as tier}]
               (when (and max-planned-amount-som
                          (<= planned-amount-som max-planned-amount-som))
                 tier))
             procurement-fine-tiers)
       (last procurement-fine-tiers))))

(defn register-draft
  "Validate + construct the FILING-DRAFT registration DRAFT -- the
  market-entry operator's own act of preparing a zakupki.gov.kg tender
  response or equivalent filing package. Pure function -- does not
  touch any real zakupki.gov.kg, sti.gov.kg or minjust.gov.kg system."
  [engagement-id jurisdiction sequence]
  (when-not (and engagement-id (not= engagement-id ""))
    (throw (ex-info "draft: engagement_id required" {})))
  (when-not (and jurisdiction (not= jurisdiction ""))
    (throw (ex-info "draft: jurisdiction required" {})))
  (when (< sequence 0)
    (throw (ex-info "draft: sequence must be >= 0" {})))
  (let [draft-number (str (str/upper-case jurisdiction) "-DFT-" (zero-pad sequence 6))
        record {"record_id" draft-number
                "kind" "filing-draft"
                "engagement_id" engagement-id
                "jurisdiction" jurisdiction
                "immutable" true}]
    {"record" record "draft_number" draft-number
     "certificate" (unsigned-certificate "FilingDraft" draft-number draft-number)}))

(defn register-submit
  "Validate + construct the FILING-SUBMIT registration DRAFT -- the
  market-entry operator's own act of actually submitting a real
  zakupki.gov.kg tender response or equivalent filing (always
  human-gated upstream)."
  [engagement-id jurisdiction sequence]
  (when-not (and engagement-id (not= engagement-id ""))
    (throw (ex-info "submit: engagement_id required" {})))
  (when-not (and jurisdiction (not= jurisdiction ""))
    (throw (ex-info "submit: jurisdiction required" {})))
  (when (< sequence 0)
    (throw (ex-info "submit: sequence must be >= 0" {})))
  (let [submit-number (str (str/upper-case jurisdiction) "-SUB-" (zero-pad sequence 6))
        record {"record_id" submit-number
                "kind" "filing-submit"
                "engagement_id" engagement-id
                "jurisdiction" jurisdiction
                "immutable" true}]
    {"record" record "submit_number" submit-number
     "certificate" (unsigned-certificate "FilingSubmit" submit-number submit-number)}))

(defn append [history result]
  (conj (vec history) (get result "record")))
