# Business Model: Independent Public-Sector Market-Entry & Procurement Compliance Service — Kyrgyz Republic

## Classification

- Repository: `cloud-itonami-iso3166-kgz`
- ISO 3166: `KGZ` (Kyrgyz Republic)
- Activity: public-procurement market-entry and ongoing regulatory-
  compliance navigation for an already-incorporated operator
- Kyrgyzstan is a member of the Eurasian Economic Union (EAEU,
  alongside Armenia, Belarus, Kazakhstan and Russia) -- own text
  confirmed directly on eaeunion.org; this is market context, not
  itself a governor-gated fact (see `marketentry.facts`'s own
  `eaeu-membership-spec-basis` and its `:eaeu-bank-guarantee-note`)

## Customer

- an already-incorporated `cloud-itonami-cofog-{code}` /
  `cloud-itonami-isco-{code}` / `cloud-itonami-unspsc-{segment}` /
  `cloud-itonami-{ISIC}` operator wanting to bid on a Kyrgyz Republic
  public contract
- a foreign SME or civic-tech vendor entering the public sector in
  Kyrgyzstan for the first time, including EAEU-member bidders who may
  rely on the EAEU's own mutual bank-guarantee-recognition mechanism
- a `cloud-itonami-M6910` client that has just completed incorporation
  and now needs public-sector market access

## Offer

- business-registration walkthrough for the Ministry of Justice's
  territorial registration divisions, a "single window" process
  (up to 3 working days per a secondary source; the Ministry of
  Justice itself transmits the new entity's data to the Tax Service,
  Social Fund and National Statistics Committee)
- public-procurement navigation for the Department of Public
  Procurement under the Ministry of Finance of the Kyrgyz Republic --
  the regulator administering the Law of the Kyrgyz Republic dated 14
  April 2022 No. 27 "On Public Procurement" (the latest of four
  successive replacement laws: 1997 -> 2004 -> 2015 -> 2022) -- via the
  live `zakupki.gov.kg` portal
- tax-registration checklist: TIN/ИНН record (auto-generated alongside
  an OKPO code at single-window registration), Tax Code of the Kyrgyz
  Republic (18 January 2022 No. 3), administered by the State Tax
  Service under the Cabinet of Ministers of the Kyrgyz Republic
- FOREIGN-INVESTMENT navigation: for engagements involving foreign
  investment, guiding the client through the National Investment
  Agency of the Kyrgyz Republic (subordinate to the President) under
  the brand-new Law "On Investments in the Kyrgyz Republic" No. 198
  (adopted by the Zhogorku Kenesh 26 June 2025, signed 12 August 2025,
  expressly superseding the 2003 No. 66 law of the same name) --
  national-treatment (Art. 11), expropriation/compensation (Art. 16-17),
  free currency transfer (Art. 13), a 3-tier dispute-resolution process
  (Art. 23), and up to a 10-year stabilization regime (Art. 3) for
  qualifying investors
- INITIAL-PROBATION-PERIOD compliance checklist: for engagements that
  declare locally-engaged staff under a probation clause, independent
  recomputation against the Labour Code of the Kyrgyz Republic's own
  Article 24 category-dependent ceiling (3 months general / 6 months
  for 7 enumerated senior/managerial categories) BEFORE any filing
  submission
- ongoing regulatory-change monitoring subscription
- compliance-audit export package for the client's own records

## Revenue

- per-engagement market-entry fee (one-time registration + checklist
  completion)
- recurring regulatory-change monitoring subscription
- compliance-audit export package

## Trust Controls

- any actual `zakupki.gov.kg` tender response or equivalent filing
  submission requires Market-Entry Compliance Governor clearance and
  always escalates to human sign-off (`:filing/submit` is never
  automated at any phase)
- a declared locally-engaged-staff initial probation period that
  exceeds the Labour Code's own Article 24 category-dependent ceiling
  (3 months general / 6 months for 7 enumerated senior categories) is a
  HARD hold that cannot be overridden by human approval alone -- the
  governor's flagship check for this vertical
- a false or fabricated regulatory-requirement claim is a HARD hold
  that cannot be overridden by human approval alone — it must be
  corrected against a cited official source first (e.g. no fabricated
  law number for the public-procurement law, no single unverified
  e-procurement portal URL asserted as canonical)
- this service does **not** provide legal or tax advice; characterization
  and filing on the client's behalf beyond checklist/draft assistance
  routes to Kyrgyzstani-licensed counsel or a registered agent
- every requirement cites the official portal or regulation, never
  invented; a genuinely well-grounded DIFFERENT-shaped mechanism this
  session found -- Article 356 of the Code of the Kyrgyz Republic "On
  Offenses" (No. 128 of 2021), a value-tiered administrative fine
  schedule for procurement-law violations -- is documented for
  transparency but deliberately NOT wired into an additional governor
  check, because its own fines fall on the procuring organization's
  officials, not on this service's own bidder-side client (see
  `marketentry.governor`'s own docstring)

## Boundary with adjacent actors (read before forking)

- **`com-etzhayyim-ooyake`** (etzhayyim/root): read-only civic-wayfinding
  mirror of government structure, non-commercial, barred from acting as
  or for the government (G3 impersonation ban). This blueprint is
  commercial and never claims to be an official channel.
- **`matsurigoto`** (etzhayyim/root): sovereign e-government statecraft —
  literally the government, for etzhayyim's own covenant or an adopting
  nation-state. This blueprint is an independent operator the government
  contracts with or that bids into its procurement — never the
  government.
- **`com-etzhayyim-toritsugi`** (etzhayyim/root): guides a consenting
  INDIVIDUAL citizen through their OWN procedure, non-profit,
  donation-only. This blueprint's client is a business operator, not an
  individual citizen, and it is commercial.
- **`legal-entity.etzhayyim.com`**: read-only aggregated company-registry
  data, no execution. This blueprint executes (gated) registrations.
- **`cloud-itonami-M6910`**: helps a client BECOME a legal entity
  (incorporation, ISIC 6910) — a prior, different regulatory phase
  (company law). This blueprint assumes incorporation is already done and
  handles public-procurement market entry (a different regulatory domain).
- **`cloud-itonami-cofog-{code}`**: a jurisdiction-agnostic operator
  template for ONE public function. This blueprint is the orthogonal
  jurisdiction-specific axis — the two compose (fork a COFOG-function
  blueprint AND this one to operate in the Kyrgyz Republic).
