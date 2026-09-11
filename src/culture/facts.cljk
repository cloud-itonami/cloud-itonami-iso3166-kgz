(ns culture.facts
  "Country-level regional-culture catalog for Kyrgyzstan (KGZ) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  `marketentry.facts` / `statute.facts` (ADR-2607141700); city-level
  counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"KGZ"
   [{:culture/id "kgz.dish.beshbarmak"
     :culture/name "Beshbarmak"
     :culture/name-local "бешбармак"
     :culture/country "KGZ"
     :culture/kind :dish
     :culture/summary "Central Asian meat, noodle and onion-broth dish traditionally eaten with the hands; strongly associated with Kyrgyzstan (particularly the Naryn region), where it is also called \"naryn\", and known by different names in neighboring countries."
     :culture/url "https://en.wikipedia.org/wiki/Beshbarmak"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "kgz.dish.manti"
     :culture/name "Manti"
     :culture/country "KGZ"
     :culture/kind :dish
     :culture/summary "Steamed dumpling of spiced meat wrapped in thin dough, found across Central Asian cuisines including Kyrgyz cuisine, typically cooked in a multi-level steamer."
     :culture/url "https://en.wikipedia.org/wiki/Manti_(food)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "kgz.dish.laghman"
     :culture/name "Laghman"
     :culture/country "KGZ"
     :culture/kind :dish
     :culture/summary "Dish of meat, vegetables and pulled noodles from Uyghur cuisine, considered a national dish of the local Uyghur and Dungan ethnic minorities in Kyrgyzstan and Kazakhstan."
     :culture/url "https://en.wikipedia.org/wiki/Laghman_(food)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "kgz.dish.boortsog"
     :culture/name "Boortsog"
     :culture/country "KGZ"
     :culture/kind :dish
     :culture/summary "Fried dough food found in the cuisines of Central Asia, Idel-Ural, Mongolia and the Middle East, traditionally prepared by Kyrgyz and other Central Asian peoples."
     :culture/url "https://en.wikipedia.org/wiki/Boortsog"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "kgz.beverage.kumis"
     :culture/name "Kumis"
     :culture/name-local "кымыз"
     :culture/country "KGZ"
     :culture/kind :beverage
     :culture/summary "Traditional fermented dairy product made from mare's milk, holding significant cultural importance in Kyrgyzstan, where the capital Bishkek is supposedly named after the paddle used to churn the fermenting milk."
     :culture/url "https://en.wikipedia.org/wiki/Kumis"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "kgz.craft.shyrdak"
     :culture/name "Shyrdak"
     :culture/name-local "шырдак"
     :culture/country "KGZ"
     :culture/kind :craft
     :culture/summary "Stitched, often colourful felt floor and wall covering, traditionally handmade in Central Asia by Kazakh and Kyrgyz people, with the practice particularly preserved in Kyrgyzstan."
     :culture/url "https://en.wikipedia.org/wiki/Shyrdak"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "kgz.craft.kalpak"
     :culture/name "Kalpak"
     :culture/country "KGZ"
     :culture/kind :craft
     :culture/summary "Turkic high-crowned cap, usually made of felt or sheepskin, worn throughout Central Asia and the Caucasus; Kyrgyz people wear white versions for special occasions."
     :culture/url "https://en.wikipedia.org/wiki/Kalpak"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "kgz.festival.world-nomad-games"
     :culture/name "World Nomad Games"
     :culture/country "KGZ"
     :culture/kind :festival
     :culture/summary "International sporting competition dedicated to ethnic and nomadic sports from Central Asia that originated in Kyrgyzstan, where the first three editions were held in Cholpon-Ata before expanding to other host countries."
     :culture/url "https://en.wikipedia.org/wiki/World_Nomad_Games"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "kgz.heritage.sulayman-mountain"
     :culture/name "Sulayman Mountain"
     :culture/name-local "Sulaiman-Too Sacred Mountain"
     :culture/country "KGZ"
     :culture/kind :heritage
     :culture/summary "Sacred mountain in Osh, Kyrgyzstan, inscribed as a UNESCO World Heritage Site in 2009 as \"the most complete example of a sacred mountain anywhere in Central Asia, worshipped over several millennia.\""
     :culture/url "https://en.wikipedia.org/wiki/Sulayman_Mountain"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "kgz.heritage.tash-rabat"
     :culture/name "Tash Rabat"
     :culture/country "KGZ"
     :culture/kind :heritage
     :culture/summary "Well-preserved 10th- or 15th-century stone caravanserai situated in the Naryn Province of Kyrgyzstan at an altitude of 3,200 meters."
     :culture/url "https://en.wikipedia.org/wiki/Tash_Rabat"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-kgz culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "KGZ"))
                 " KGZ entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
