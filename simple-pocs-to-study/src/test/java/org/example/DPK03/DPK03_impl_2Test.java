package org.example.DPK03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("DPK03_impl_2 Test Suite")
class DPK03_impl_2Test {

    private Map<Integer, String> idNameMap;

    @BeforeEach
    void setUp() {
        idNameMap = new HashMap<>();
        idNameMap.put(1, "John");
        idNameMap.put(2, "Jane");
        idNameMap.put(3, "Doe");
    }

    @Nested
    @DisplayName("lookup Method Tests")
    class LookupTests {
        
        @Test
        @DisplayName("Should return correct name for existing ID")
        void shouldReturnNameForExistingId() {
            String result = DPK03_impl_2.lookup(idNameMap, 1);
            assertEquals("John", result);
        }

        @Test
        @DisplayName("Should return correct name for ID 2")
        void shouldReturnNameForId2() {
            String result = DPK03_impl_2.lookup(idNameMap, 2);
            assertEquals("Jane", result);
        }

        @Test
        @DisplayName("Should return correct name for ID 3")
        void shouldReturnNameForId3() {
            String result = DPK03_impl_2.lookup(idNameMap, 3);
            assertEquals("Doe", result);
        }

        @Test
        @DisplayName("Should return 'Key not found' for non-existing ID")
        void shouldReturnKeyNotFoundForNonExistingId() {
            String result = DPK03_impl_2.lookup(idNameMap, 4);
            assertEquals("Key not found", result);
        }

        @Test
        @DisplayName("Should return 'Key not found' for negative ID")
        void shouldReturnKeyNotFoundForNegativeId() {
            String result = DPK03_impl_2.lookup(idNameMap, -1);
            assertEquals("Key not found", result);
        }

        @Test
        @DisplayName("Should return 'Key not found' for null ID")
        void shouldReturnKeyNotFoundForNullId() {
            String result = DPK03_impl_2.lookup(idNameMap, null);
            assertEquals("Key not found", result);
        }

        @Test
        @DisplayName("Should handle empty map")
        void shouldHandleEmptyMap() {
            Map<Integer, String> emptyMap = new HashMap<>();
            String result = DPK03_impl_2.lookup(emptyMap, 1);
            assertEquals("Key not found", result);
        }

        @Test
        @DisplayName("Should work with large ID numbers")
        void shouldWorkWithLargeIdNumbers() {
            idNameMap.put(999999, "LargeId");
            String result = DPK03_impl_2.lookup(idNameMap, 999999);
            assertEquals("LargeId", result);
        }

        @Test
        @DisplayName("Should handle map with multiple entries")
        void shouldHandleMapWithMultipleEntries() {
            for (int i = 4; i <= 10; i++) {
                idNameMap.put(i, "Person" + i);
            }
            assertEquals("Person5", DPK03_impl_2.lookup(idNameMap, 5));
            assertEquals("Person10", DPK03_impl_2.lookup(idNameMap, 10));
        }

        @Test
        @DisplayName("Should preserve original map after lookup")
        void shouldPreserveOriginalMapAfterLookup() {
            int originalSize = idNameMap.size();
            DPK03_impl_2.lookup(idNameMap, 1);
            DPK03_impl_2.lookup(idNameMap, 100);
            assertEquals(originalSize, idNameMap.size());
        }
    }
}

