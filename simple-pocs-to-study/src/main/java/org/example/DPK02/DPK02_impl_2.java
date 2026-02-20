package org.example.DPK02;

import java.util.HashMap;
import java.util.Map;

public class DPK02_impl_2 {

    private static final Map<String, String> COUNTRY_LANGUAGE_MAP = new HashMap<>();

    static {
        COUNTRY_LANGUAGE_MAP.put("USA", "English");
        COUNTRY_LANGUAGE_MAP.put("BRAZIL", "Portuguese");
        COUNTRY_LANGUAGE_MAP.put("SPAIN", "Spanish");
        COUNTRY_LANGUAGE_MAP.put("ITALY", "Italian");
        COUNTRY_LANGUAGE_MAP.put("FRANCE", "French");
        COUNTRY_LANGUAGE_MAP.put("GERMANY", "German");
    }

    public static String pattern_matcher(String country) {
        return COUNTRY_LANGUAGE_MAP.getOrDefault(
            country.toUpperCase(),
            "Unknown Country"
        );
    }

    public static void addCountryLanguage(String country, String language) {
        COUNTRY_LANGUAGE_MAP.put(country.toUpperCase(), language);
    }

    public static boolean isCountrySupported(String country) {
        return COUNTRY_LANGUAGE_MAP.containsKey(country.toUpperCase());
    }

    public static Map<String, String> getAllCountryLanguages() {
        return new HashMap<>(COUNTRY_LANGUAGE_MAP);
    }
}

