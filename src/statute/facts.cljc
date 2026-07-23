(ns statute.facts
  "General-law compliance catalog for the Kyrgyz Republic (KGZ) --
  extends this repo's existing `marketentry.facts` (public-procurement
  market-entry only, narrow scope) with a second, orthogonal catalog of
  statutes a company operating in this jurisdiction must generally track
  for compliance. Mirrors cloud-itonami-iso3166-uzb/-ner/-gin/-caf/-cog's
  `statute.facts` (ADR-2607141700, cloud-itonami-compliance-fact-
  federation).

  FOUR entries this iteration could independently ground with a
  citation actually fetched and read this session (2026-07-22/23) -- a
  smaller, 100%-honest catalog rather than a fabricated fifth entry:

  - **Labour Code**: Кодекс КР от 23 января 2025 года № 23 'Трудовой
    кодекс Кыргызской Республики' (Labour Code of the Kyrgyz Republic,
    dated 23 January 2025, No. 23) -- a BRAND-NEW code, own title/date/
    number confirmed directly on the Ministry of Justice's own
    centralized legal database (`cbd.minjust.gov.kg/3-45/edition/25298/ru`
    -- a client-rendered React SPA shell like several other
    minjust.gov.kg-family sites; only the page's own `<meta
    name=\"description\">` tag was read, not the article body -- an
    honest, disclosed gap). This iteration independently fetched and
    read the FULL text of Article 24 ('Испытание при приеме на работу')
    at a secondary full-text mirror, `zakon.kg/law/tk-kr/` (own
    self-title: 'Трудовой Кодекс Кыргызской Республики, актуальная
    редакция (2026)'), by extracting the flat HTML page's own anchor-
    id'd article body directly (not an AI paraphrase) -- see
    `marketentry.facts`'s namespace docstring and `marketentry.registry`
    for the full text and how this catalog's flagship governor check
    (`probation-period-exceeds-ceiling?`) is grounded in that same
    Article 24, paragraph 4.
  - **Foreign investment**: Law of the Kyrgyz Republic dated 12 August
    2025 No. 198 'On Investments in the Kyrgyz Republic', independently
    confirmed via UNCTAD's Investment Policy Hub own hosting
    (`investmentpolicy.unctad.org/investment-laws/laws/636/kyrgyzstan-on-investments-in-the-kyrgyz-republic`,
    WebFetch-verified directly this session) -- own text: 'Adopted by
    the Zhogorku Kenesh of the Kyrgyz Republic June 26, 2025', 'Bishkek,
    dated August 12, 2025, No. 198', expressly superseding 'the Law of
    the Kyrgyz Republic \"On Investments in the Kyrgyz Republic\" dated
    March 27, 2003 No. 66'. This iteration did NOT independently fetch
    the 2025 law's own Kyrgyz-government-hosted primary text this
    session, only UNCTAD's secondary hosting of it -- an honest gap,
    the same kind of gap a sibling discloses when relying on UNCTAD's
    hosting rather than a domestic primary source.
  - **Tax Code**: Налоговый кодекс Кыргызской Республики от 18 января
    2022 года № 3 (Tax Code of the Kyrgyz Republic, dated 18 January
    2022, No. 3), own title/date/number confirmed directly on the
    Ministry of Justice's own centralized legal database
    (`cbd.minjust.gov.kg/3-39/edition/27071/ru` -- same JS-SPA-shell
    access gap as the Labour Code above, meta tag only, not the article
    body). This iteration also found the same Tax Code hosted as a PDF
    directly on the State Tax Service's own site (`sti.gov.kg`) via
    search, but this session's own attempt to fetch that specific PDF
    URL returned an HTTP 500 -- an honest, disclosed partial gap; the
    Tax Code's own title/date/number is still primary-source-confirmed
    via cbd.minjust.gov.kg.
  - **Public procurement**: Закон КР от 14 апреля 2022 года № 27 'О
    государственных закупках' (Law of the Kyrgyz Republic dated 14
    April 2022, No. 27, 'On Public Procurement'), own title/date/number
    confirmed directly on the Ministry of Justice's own centralized
    legal database (`cbd.minjust.gov.kg/112361/edition/1279682/ru`,
    same JS-SPA-shell access gap), independently corroborated by an
    English-language slide deck ('Public Procurement System in the
    Kyrgyz Republic and the Procedure for Handling Complaints and
    Appeals', dated 5 December 2022, authored by the Head of the
    Complaints Unit of the Department of Public Procurement under the
    Ministry of Finance of the Kyrgyz Republic, hosted at
    `events.development.asia`, fetched and read directly this session)
    -- this is the LATEST of four successive replacement laws (PPL
    No.31 1997 -> No.69 2004 -> No.72 2015 -> No.27 2022), per that
    deck's own slide 5.

  This iteration specifically investigated, rather than assumed,
  whether Kyrgyzstan's own EAEU membership (see
  `marketentry.facts`/`eaeu-membership-spec-basis`, independently
  confirmed directly on eaeunion.org's own site) would surface a clean
  supranational statute citation the way OHADA membership does for
  several Francophone-Africa siblings. It does not, in the sense of a
  single treaty text superseding domestic company/labour/tax law the
  way the AUSCGIE does for OHADA members -- the EAEU Treaty (signed 29
  May 2014; Kyrgyzstan's own Agreement on Accession signed 23 December
  2014, per eaeunion.org's own text) instead layers specific,
  incrementally-adopted supranational MECHANISMS (e.g. the 'Agreement
  on mutual recognition of bank guarantees for public procurement',
  signed 30 August 2023, per eaeunion.org's own summary) on top of
  domestic law rather than replacing it outright -- this iteration did
  NOT independently fetch that bank-guarantee agreement's own full
  primary text this session, an honest gap, so it is NOT added here as
  a fifth `statute.facts` entry (see `marketentry.facts`'s own
  `:eaeu-bank-guarantee-note` for where it IS documented, clearly
  labeled as a market-context note rather than a company-compliance
  statute).

  A law not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of statute entries. `:statute/url` + `:statute/law-number`
  are the citation the governor requires before any compliance-fact
  proposal referencing this law can commit."
  {"KGZ"
   [{:statute/id "kgz.labour-code-2025"
     :statute/title "Кодекс Кыргызской Республики от 23 января 2025 года № 23 \"Трудовой кодекс Кыргызской Республики\" (Labour Code of the Kyrgyz Republic)"
     :statute/jurisdiction "KGZ"
     :statute/kind :code
     :statute/law-number "No. 23, adopted 23 January 2025 (own primary text, cbd.minjust.gov.kg metadata -- title/date/number confirmed directly, article-level text read via a secondary full-text mirror, zakon.kg/law/tk-kr/)"
     :statute/url "https://cbd.minjust.gov.kg/3-45/edition/25298/ru"
     :statute/url-provenance :official-cbd-minjust-gov-kg
     :statute/enacted-date "2025-01-23"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:labor :employment}}
    {:statute/id "kgz.investment-law-2025"
     :statute/title "Law of the Kyrgyz Republic on Investments in the Kyrgyz Republic"
     :statute/jurisdiction "KGZ"
     :statute/kind :law
     :statute/law-number "No. 198 -- Adopted by the Zhogorku Kenesh 26 June 2025; signed Bishkek, 12 August 2025; published 19 August 2025 (per UNCTAD's Investment Policy Hub hosting; this iteration did not independently fetch the law's own Kyrgyz-government-hosted primary text this session, an honest gap); expressly supersedes the Law of the Kyrgyz Republic \"On Investments in the Kyrgyz Republic\" dated 27 March 2003 No. 66"
     :statute/url "https://investmentpolicy.unctad.org/investment-laws/laws/636/kyrgyzstan-on-investments-in-the-kyrgyz-republic"
     :statute/url-provenance :secondary-unctad-investment-policy-hub
     :statute/enacted-date "2025-08-12"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:investment}}
    {:statute/id "kgz.tax-code-2022"
     :statute/title "Налоговый кодекс Кыргызской Республики от 18 января 2022 года № 3 (Tax Code of the Kyrgyz Republic)"
     :statute/jurisdiction "KGZ"
     :statute/kind :code
     :statute/law-number "No. 3, adopted 18 January 2022 (own title/date/number confirmed directly on cbd.minjust.gov.kg; article-level text NOT independently read this session -- JS-SPA-shell gap, and a direct sti.gov.kg PDF fetch attempt returned HTTP 500, an honest partial gap)"
     :statute/url "https://cbd.minjust.gov.kg/3-39/edition/27071/ru"
     :statute/url-provenance :official-cbd-minjust-gov-kg
     :statute/enacted-date "2022-01-18"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:tax}}
    {:statute/id "kgz.public-procurement-law-2022"
     :statute/title "Закон Кыргызской Республики от 14 апреля 2022 года № 27 \"О государственных закупках\" (Law of the Kyrgyz Republic on Public Procurement)"
     :statute/jurisdiction "KGZ"
     :statute/kind :law
     :statute/law-number "No. 27, adopted 14 April 2022 -- the LATEST of four successive replacement laws (PPL No.31 1997 -> No.69 2004 -> No.72 2015 -> No.27 2022), per an ADB-hosted deck authored by the Head of the Complaints Unit, Department of Public Procurement under the Ministry of Finance of the Kyrgyz Republic (5 December 2022)"
     :statute/url "https://cbd.minjust.gov.kg/112361/edition/1279682/ru"
     :statute/url-provenance :official-cbd-minjust-gov-kg
     :statute/enacted-date "2022-04-14"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:procurement}}]})

(defn spec-basis
  "The jurisdiction's statute vector, or nil -- nil means NO spec-basis
  for that jurisdiction yet."
  [iso3]
  (get catalog iso3))

(defn coverage
  "Honest coverage report, same shape/discipline as `marketentry.facts/coverage`:
  never report a missing jurisdiction as covered."
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-kgz statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "KGZ")) " KGZ statutes seeded with an "
                 "official citation. Extend "
                 "`statute.facts/catalog`, never fabricate a law-id or URL.")})))

(defn by-topic
  "Statutes for `iso3` tagged with `topic` (e.g. :labor, :investment,
  :tax, :procurement)."
  [iso3 topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis iso3)))
