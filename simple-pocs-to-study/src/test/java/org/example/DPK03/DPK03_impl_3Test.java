package org.example.DPK03;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DPK03_impl_3Test {

    @Test
    void lookupShouldReturnValueWhenKeyExists() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "John");
        map.put(2, "Jane");
        map.put(3, "Doe");

        String result = DPK03_impl_3.lookup(map, 1);

        assertEquals("John", result);
    }

    @Test
    void lookupShouldReturnKeyNotFoundWhenKeyDoesNotExist() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "John");
        map.put(2, "Jane");

        String result = DPK03_impl_3.lookup(map, 99);

        assertEquals("Key not found", result);
    }

    @Test
    void lookupShouldReturnKeyNotFoundWhenMapIsNull() {
        String result = DPK03_impl_3.lookup(null, 1);

        assertEquals("Key not found", result);
    }

    @Test
    void lookupShouldReturnKeyNotFoundWhenIdIsNull() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "John");

        String result = DPK03_impl_3.lookup(map, null);

        assertEquals("Key not found", result);
    }

    @Test
    void lookupShouldReturnKeyNotFoundWhenMapIsEmpty() {
        Map<Integer, String> map = new HashMap<>();

        String result = DPK03_impl_3.lookup(map, 1);

        assertEquals("Key not found", result);
    }

    @Test
    void lookupOptionalShouldReturnPresentWhenKeyExists() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "John");
        map.put(2, "Jane");

        Optional<String> result = DPK03_impl_3.lookupOptional(map, 2);

        assertTrue(result.isPresent());
        assertEquals("Jane", result.get());
    }

    @Test
    void lookupOptionalShouldReturnEmptyWhenKeyDoesNotExist() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "John");

        Optional<String> result = DPK03_impl_3.lookupOptional(map, 99);

        assertFalse(result.isPresent());
    }

    @Test
    void lookupOptionalShouldReturnEmptyWhenMapIsNull() {
        Optional<String> result = DPK03_impl_3.lookupOptional(null, 1);

        assertFalse(result.isPresent());
    }

    @Test
    void lookupOptionalShouldReturnEmptyWhenIdIsNull() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "John");

        Optional<String> result = DPK03_impl_3.lookupOptional(map, null);

        assertFalse(result.isPresent());
    }

    @Test
    void lookupWithDefaultShouldReturnValueWhenKeyExists() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "John");
        map.put(2, "Jane");

        String result = DPK03_impl_3.lookupWithDefault(map, 1, "Default");

        assertEquals("John", result);
    }

    @Test
    void lookupWithDefaultShouldReturnCustomDefaultWhenKeyDoesNotExist() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "John");

        String result = DPK03_impl_3.lookupWithDefault(map, 99, "Custom Default");

        assertEquals("Custom Default", result);
    }

    @Test
    void lookupWithDefaultShouldReturnDefaultWhenMapIsNull() {
        String result = DPK03_impl_3.lookupWithDefault(null, 1, "Default Value");

        assertEquals("Default Value", result);
    }

    @Test
    void lookupWithDefaultShouldReturnDefaultWhenIdIsNull() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "John");

        String result = DPK03_impl_3.lookupWithDefault(map, null, "Default Value");

        assertEquals("Default Value", result);
    }

    @Test
    void lookupShouldHandleMultipleEntries() {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 1; i <= 100; i++) {
            map.put(i, "Name" + i);
        }

        String result = DPK03_impl_3.lookup(map, 50);

        assertEquals("Name50", result);
    }

    @Test
    void lookupOptionalShouldHandleNullValuesInMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, null);
        map.put(2, "Jane");

        Optional<String> result = DPK03_impl_3.lookupOptional(map, 1);

        assertFalse(result.isPresent());
    }

    @Test
    void lookupWithDefaultShouldReturnValueEvenWhenValueIsNull() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, null);

        String result = DPK03_impl_3.lookupWithDefault(map, 1, "Default");

        assertNull(result);
    }
}

