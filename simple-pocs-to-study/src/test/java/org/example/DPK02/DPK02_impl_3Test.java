package org.example.DPK02;

import org.junit.jupiter.api.Test;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DPK02_impl_3Test {
    @Test
    void testDefaultPatternMatcher() {
        DPK02_impl_3 matcher = DPK02_impl_3.builder().build();
        assertEquals("English", matcher.patternMatcher("usa"));
        assertEquals("Portuguese", matcher.patternMatcher("BRAZIL"));
        assertEquals("Spanish", matcher.patternMatcher("Spain"));
        assertEquals("Unknown Country", matcher.patternMatcher("JAPAN"));
        assertEquals("Unknown Country", matcher.patternMatcher(null));
    }

    @Test
    void testCustomCountryLanguage() {
        DPK02_impl_3 matcher = DPK02_impl_3.builder()
                .addCountryLanguage("JAPAN", "Japanese")
                .addCountryLanguage("KOREA", "Korean")
                .build();
        assertEquals("Japanese", matcher.patternMatcher("japan"));
        assertEquals("Korean", matcher.patternMatcher("KOREA"));
        assertEquals("Unknown Country", matcher.patternMatcher("USA"));
    }

    @Test
    void testIsCountrySupported() {
        DPK02_impl_3 matcher = DPK02_impl_3.builder().build();
        assertTrue(matcher.isCountrySupported("usa"));
        assertFalse(matcher.isCountrySupported("japan"));
        assertFalse(matcher.isCountrySupported(null));
    }

    @Test
    void testGetAllCountryLanguagesImmutability() {
        DPK02_impl_3 matcher = DPK02_impl_3.builder().build();
        Map<String, String> map = matcher.getAllCountryLanguages();
        assertThrows(UnsupportedOperationException.class, () -> map.put("JAPAN", "Japanese"));
    }
}

