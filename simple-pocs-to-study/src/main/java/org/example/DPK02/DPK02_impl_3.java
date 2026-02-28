package org.example.DPK02;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class DPK02_impl_3 {
    private final Map<String, String> countryLanguageMap;

    private DPK02_impl_3(Map<String, String> countryLanguageMap) {
        this.countryLanguageMap = Collections.unmodifiableMap(new HashMap<>(countryLanguageMap));
    }

    public String patternMatcher(String country) {
        if (country == null) return "Unknown Country";
        return countryLanguageMap.getOrDefault(country.toUpperCase(), "Unknown Country");
    }

    public boolean isCountrySupported(String country) {
        if (country == null) return false;
        return countryLanguageMap.containsKey(country.toUpperCase());
    }

    public Map<String, String> getAllCountryLanguages() {
        return countryLanguageMap;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private final Map<String, String> map = new HashMap<>();

        public Builder addCountryLanguage(String country, String language) {
            Objects.requireNonNull(country, "country");
            Objects.requireNonNull(language, "language");
            map.put(country.toUpperCase(), language);
            return this;
        }

        public DPK02_impl_3 build() {
            // Add default countries
            if (map.isEmpty()) {
                addCountryLanguage("USA", "English");
                addCountryLanguage("BRAZIL", "Portuguese");
                addCountryLanguage("SPAIN", "Spanish");
                addCountryLanguage("ITALY", "Italian");
                addCountryLanguage("FRANCE", "French");
                addCountryLanguage("GERMANY", "German");
            }
            return new DPK02_impl_3(map);
        }
    }
}
