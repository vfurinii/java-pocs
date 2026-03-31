package org.example.DPK03;

import java.util.Map;
import java.util.Optional;

public class DPK03_impl_3 {

    private static final String KEY_NOT_FOUND = "Key not found";

    public static String lookup(Map<Integer, String> idNameMap, Integer id) {
        return getString(idNameMap, id, KEY_NOT_FOUND);
    }

    public static Optional<String> lookupOptional(Map<Integer, String> idNameMap, Integer id) {
        if (idNameMap == null || id == null) {
            return Optional.empty();
        }

        for (Map.Entry<Integer, String> entry : idNameMap.entrySet()) {
            if (entry.getKey().equals(id)) {
                return Optional.ofNullable(entry.getValue());
            }
        }
        return Optional.empty();
    }

    public static String lookupWithDefault(Map<Integer, String> idNameMap, Integer id, String defaultValue) {
        return getString(idNameMap, id, defaultValue);
    }

    private static String getString(Map<Integer, String> idNameMap, Integer id, String defaultValue) {
        if (idNameMap == null || id == null) {
            return defaultValue;
        }

        for (Map.Entry<Integer, String> entry : idNameMap.entrySet()) {
            if (entry.getKey().equals(id)) {
                return entry.getValue();
            }
        }
        return defaultValue;
    }
}
