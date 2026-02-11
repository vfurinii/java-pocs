package org.example;

import org.example.models.DPK03;

import java.util.Map;

public class DPK02_impl_1 {

    public static DPK03 lookupById(Map<String, DPK03> map, String id) {
        return map.get(id);
    }

    public static DPK03 lookupByName(Map<String, DPK03> map, String name) {
        return map.values().stream()
                .filter(dpk03 -> dpk03.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}

