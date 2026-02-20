package org.example.DPK02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class DPK02_impl_2Test {

    @BeforeEach
    void setUp() {
        // Reset the map to its original state before each test
        // by re-initializing if needed
    }

    @Test
    @DisplayName("Should return correct language for USA")
    void testPatternMatcherUSA() {
        String result = DPK02_impl_2.pattern_matcher("USA");
        assertEquals("English", result);
    }

    @Test
    @DisplayName("Should return correct language for Brazil")
    void testPatternMatcherBrazil() {
        String result = DPK02_impl_2.pattern_matcher("BRAZIL");
        assertEquals("Portuguese", result);
    }

    @Test
    @DisplayName("Should return correct language for Spain")
    void testPatternMatcherSpain() {
        String result = DPK02_impl_2.pattern_matcher("SPAIN");
        assertEquals("Spanish", result);
    }

    @Test
    @DisplayName("Should return correct language for Italy")
    void testPatternMatcherItaly() {
        String result = DPK02_impl_2.pattern_matcher("ITALY");
        assertEquals("Italian", result);
    }

    @Test
    @DisplayName("Should return correct language for France")
    void testPatternMatcherFrance() {
        String result = DPK02_impl_2.pattern_matcher("FRANCE");
        assertEquals("French", result);
    }

    @Test
    @DisplayName("Should return correct language for Germany")
    void testPatternMatcherGermany() {
        String result = DPK02_impl_2.pattern_matcher("GERMANY");
        assertEquals("German", result);
    }

    @Test
    @DisplayName("Should return 'Unknown Country' for unsupported country")
    void testPatternMatcherUnknownCountry() {
        String result = DPK02_impl_2.pattern_matcher("AUSTRALIA");
        assertEquals("Unknown Country", result);
    }

    @Test
    @DisplayName("Should handle lowercase country names")
    void testPatternMatcherLowercase() {
        String result = DPK02_impl_2.pattern_matcher("usa");
        assertEquals("English", result);
    }

    @Test
    @DisplayName("Should handle mixed case country names")
    void testPatternMatcherMixedCase() {
        String result = DPK02_impl_2.pattern_matcher("BrAzIl");
        assertEquals("Portuguese", result);
    }

    @Test
    @DisplayName("Should add new country-language mapping")
    void testAddCountryLanguage() {
        DPK02_impl_2.addCountryLanguage("JAPAN", "Japanese");
        String result = DPK02_impl_2.pattern_matcher("JAPAN");
        assertEquals("Japanese", result);
    }

    @Test
    @DisplayName("Should add new country-language mapping with lowercase input")
    void testAddCountryLanguageLowercase() {
        DPK02_impl_2.addCountryLanguage("canada", "English/French");
        String result = DPK02_impl_2.pattern_matcher("CANADA");
        assertEquals("English/French", result);
    }

    @Test
    @DisplayName("Should check if country is supported - positive case")
    void testIsCountrySupportedTrue() {
        assertTrue(DPK02_impl_2.isCountrySupported("USA"));
    }

    @Test
    @DisplayName("Should check if country is supported - negative case")
    void testIsCountrySupportedFalse() {
        assertFalse(DPK02_impl_2.isCountrySupported("AUSTRALIA"));
    }

    @Test
    @DisplayName("Should check if country is supported with lowercase")
    void testIsCountrySupportedLowercase() {
        assertTrue(DPK02_impl_2.isCountrySupported("spain"));
    }

    @Test
    @DisplayName("Should return all country-language mappings")
    void testGetAllCountryLanguages() {
        Map<String, String> allMappings = DPK02_impl_2.getAllCountryLanguages();

        assertNotNull(allMappings);
        assertTrue(allMappings.size() >= 6);
        assertTrue(allMappings.containsKey("USA"));
        assertTrue(allMappings.containsKey("BRAZIL"));
        assertEquals("English", allMappings.get("USA"));
        assertEquals("Portuguese", allMappings.get("BRAZIL"));
    }

    @Test
    @DisplayName("Should return a copy of the map, not the original")
    void testGetAllCountryLanguagesReturnsCopy() {
        Map<String, String> allMappings = DPK02_impl_2.getAllCountryLanguages();
        allMappings.put("TEST", "TestLanguage");

        // The original map should not be affected
        assertFalse(DPK02_impl_2.isCountrySupported("TEST"));
    }

    @Test
    @DisplayName("Should override existing country-language mapping")
    void testOverrideCountryLanguage() {
        DPK02_impl_2.addCountryLanguage("USA", "American English");
        String result = DPK02_impl_2.pattern_matcher("USA");
        assertEquals("American English", result);

        // Reset for other tests
        DPK02_impl_2.addCountryLanguage("USA", "English");
    }

    @Test
    @DisplayName("Should handle empty string input")
    void testPatternMatcherEmptyString() {
        String result = DPK02_impl_2.pattern_matcher("");
        assertEquals("Unknown Country", result);
    }

    @Test
    @DisplayName("Should handle null input gracefully")
    void testPatternMatcherNullInput() {
        assertThrows(NullPointerException.class, () -> {
            DPK02_impl_2.pattern_matcher(null);
        });
    }
}

