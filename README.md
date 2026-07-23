# cloud-itonami-iso3166-kgz

**KGZ**: Kyrgyz Republic. Also a member of the Eurasian Economic Union
(EAEU, alongside Armenia, Belarus, Kazakhstan and Russia) -- own text
confirmed directly on eaeunion.org.

- Public procurement governed by the Law of the Kyrgyz Republic dated
  14 April 2022 No. 27 "On Public Procurement" (own title/date/number
  confirmed directly on the Ministry of Justice's own centralized
  legal database, cbd.minjust.gov.kg) -- the latest of four successive
  replacement laws (1997 -> 2004 -> 2015 -> 2022), regulated by the
  Department of Public Procurement under the Ministry of Finance of
  the Kyrgyz Republic; live portal at `zakupki.gov.kg`.
- TIN/ИНН tax registration via the State Tax Service under the Cabinet
  of Ministers of the Kyrgyz Republic (`sti.gov.kg`); business
  registration via the Ministry of Justice's territorial single-window
  process (`minjust.gov.kg`, up to 3 working days per a secondary
  source; a dedicated `register.minjust.gov.kg` subdomain exists but
  is Cloudflare-challenge-gated and was not independently read this
  session); foreign investment under the brand-new Law "On Investments
  in the Kyrgyz Republic" No. 198 (2025), administered by the National
  Investment Agency of the Kyrgyz Republic.
- Labour Code of the Kyrgyz Republic (adopted 23 January 2025 No. 23)
  Article 24 initial-probation-period statutory ceiling -- a
  category-dependent gate (3 months general / 6 months for 7
  enumerated senior/managerial categories) on any declared
  locally-engaged-staff probation period (flagship check).

AGPL-3.0-or-later.

## Market-entry / statute catalogs

Governed public-sector market-entry compliance actor, same architecture
as `cloud-itonami-iso3166-uzb` (the closest architectural match this
iteration studied in depth):

- `src/marketentry/{facts,governor,phase,sim,operation,registry,store,
  marketentryllm}.cljc` -- the actor. `facts.cljc` cites Law No. 27
  (public procurement legal basis), the `zakupki.gov.kg` information
  portal, the State Tax Service (`sti.gov.kg`, TIN/ИНН tax
  registration), the Ministry of Justice's single-window business-
  registration process, and the Law "On Investments in the Kyrgyz
  Republic" No. 198 (2025, National Investment Agency) -- with every
  honestly-disclosed access gap (JS-only SPA shells, an active
  Cloudflare challenge on `register.minjust.gov.kg`, a DuckDuckGo image
  CAPTCHA hit partway through this session's own web searches, an HTTP
  500 on a direct sti.gov.kg PDF fetch) documented in the namespace
  docstring rather than papered over. `governor.cljc`'s flagship check
  independently recomputes whether an engagement's own declared
  locally-engaged-staff initial probation period exceeds the Labour
  Code's own Article 24 category-dependent statutory ceiling -- found
  by directly reading Article 24's own full text at a secondary
  full-text mirror (title/date/number independently cross-confirmed on
  the Ministry of Justice's own site), not adapted from any sibling.
  This session also independently found a genuinely well-grounded,
  DIFFERENTLY-SHAPED mechanism -- Article 356 of the Code of the Kyrgyz
  Republic "On Offenses" (No. 128 of 2021), a value-tiered
  administrative fine schedule for procurement-law violations -- and
  deliberately documented it (`marketentry.facts/procurement-fine-
  tier-spec-basis`, `marketentry.registry/procurement-violation-fine-
  ci`) WITHOUT wiring it into an additional HARD governor check, because
  its own fines fall on the procuring organization's officials, not on
  this actor's own bidder-side operator (see `marketentry.governor`'s
  docstring for the full reasoning).
- `src/statute/facts.cljc` -- general-law catalog: the Labour Code of
  the Kyrgyz Republic (adopted 23 January 2025 No. 23), the Tax Code
  (18 January 2022 No. 3), the Law "On Public Procurement" (14 April
  2022 No. 27), and the Law "On Investments in the Kyrgyz Republic"
  (12 August 2025 No. 198, per UNCTAD's Investment Policy Hub hosting).
  This iteration specifically investigated, rather than assumed by
  analogy to OHADA-member siblings, whether Kyrgyzstan's own EAEU
  membership would surface a clean supranational statute citation the
  way OHADA membership does for several Francophone-Africa siblings --
  it does not, in the same shape; the EAEU instead layers specific
  incremental mechanisms (e.g. an August 2023 agreement on mutual
  recognition of bank guarantees for public procurement) on top of
  domestic law, documented in `marketentry.facts` as a market-context
  note rather than a `statute.facts` entry (this iteration did not
  independently fetch that agreement's own full primary text this
  session).

Every citation is curl/WebFetch-verified against an official source
(eaeunion.org, cbd.minjust.gov.kg, zakupki.gov.kg, sti.gov.kg,
minjust.gov.kg, invest.gov.kg) or a secondary source (UNCTAD's
Investment Policy Hub, an ADB-hosted deck authored by the Ministry of
Finance's own Department of Public Procurement Complaints Unit head,
zakon.kg legal-guide pages, a tobacco-control-law excerpt PDF used only
to cross-confirm a code's own title/date/number). Refworld and one
`leap.unep.org` link both returned HTTP 403 this session and were NOT
retried around; `register.minjust.gov.kg` is gated by an active
Cloudflare challenge both live and in its own Wayback Machine snapshot,
NOT bypassed per this project's hard safety rule; this session's own
DuckDuckGo HTML search hit an image CAPTCHA partway through and was
likewise not bypassed (remaining lookups used a different, unblocked
resource). See `marketentry.facts`'s and `statute.facts`'s docstrings
for exactly which facts are HIGH confidence vs. an honestly-flagged gap.

## Culture catalog

Alongside the market-entry / statute catalogs, this repo carries a
**country-level regional-culture catalog** (ADR-2607171400 addendum 2,
`cloud-itonami-municipality-culture-catalog` Wave 1, in
`com-junkawasaki/root`) — national dishes, protected products, beverages,
crafts, festivals and heritage sites for Kyrgyzstan:

- `src/culture/facts.cljc` — the catalog, source of truth (keyed by
  uppercase ISO3, mirroring `statute.facts`).
- `schema/culture.edn` — DataScript schema.
- `data/culture-tx.edn` — derived DataScript tx-data (regenerated from
  the catalog, never hand-edited).

City-level counterparts live in the `cloud-itonami-municipality-*` repos.
Same provenance discipline as the compliance catalogs: every entry cites a
source URL that was actually fetched and read on `:culture/retrieved-at`;
summaries state only what the cited source confirms. An item not in
`culture.facts/catalog` has no spec-basis — never fabricate one.
