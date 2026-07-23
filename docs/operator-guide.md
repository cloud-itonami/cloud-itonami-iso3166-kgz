# Operator Guide

## First Deployment

1. Confirm the client's incorporation/legal-entity status is complete
   (route to `cloud-itonami-M6910` or local counsel first if not).
2. Register the client's intake: business type, target public function,
   prior filing history in Kyrgyzstan if any.
3. Run the advisor in read-only mode against the Department of Public
   Procurement's `zakupki.gov.kg` electronic procurement portal (own
   `<title>` tag independently confirmed this session: "Единая
   платформа закупок" / "Unified Procurement Platform").
4. Compare the checklist against the client's current documentation
   (Ministry of Justice single-window business-registration status,
   Law "On Public Procurement" No. 27 (2022) compliance record, TIN/ИНН
   tax-registration record from the State Tax Service).
5. If the engagement involves foreign investment, route to the
   National Investment Agency of the Kyrgyz Republic (subordinate to
   the President) for clearance under the Law "On Investments in the
   Kyrgyz Republic" No. 198 (2025) BEFORE any filing submission -- this
   is a HARD governor gate, not optional.
6. If the engagement declares locally-engaged staff under an initial
   probation clause, verify the declared duration against the Labour
   Code of the Kyrgyz Republic's own Article 24 category-dependent
   ceiling (3 months general / 6 months for heads of organizations and
   their deputies, chief accountants and their deputies, heads of
   branches, representative offices, and other separate structural
   subdivisions) BEFORE `:filing/submit` -- the governor's flagship
   check for this vertical, unconditionally rejected on violation.
7. Enable gated filing-draft assistance once the Market-Entry Compliance
   Governor contract is trusted; actual submission always requires human
   sign-off.

## Minimum Production Controls

- client-owned data store for business/tax registration documents
- clear provenance (official portal/regulation citation) for every
  requirement surfaced
- approval workflow for any portal registration or filing submission
- named referral relationship with Kyrgyzstani-licensed counsel or a
  registered agent for anything beyond checklist/draft assistance
- monthly audit export

## A note on `register.minjust.gov.kg`

The Ministry of Justice's own dedicated legal-entity registration
subdomain (`register.minjust.gov.kg`) is gated by an active Cloudflare
challenge-platform script -- both live and in its own Wayback Machine
snapshot, this session's own fetch tooling could not read past the
challenge bootstrap script, and per this project's hard safety rule
this was NOT bypassed by any means. Operators integrating with this
subdomain directly (rather than through `marketentry.facts`'s own
documented, honestly-gapped citation) should independently re-verify
its current process before relying on it in production.

## Certification

Certified operators must prove data provenance, audit traceability, that
automated actions cannot bypass the Market-Entry Compliance Governor,
that a declared probation period is always independently checked
against the Labour Code's own Article 24 ceiling before submission, and
a working referral relationship with Kyrgyzstani-licensed counsel or a
registered agent for whatever licensed representation the law of the
Kyrgyz Republic requires for actual public-procurement filings.
