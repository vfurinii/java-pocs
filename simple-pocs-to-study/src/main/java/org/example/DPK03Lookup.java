package org.example;

import java.util.Map;

public class DPK03Lookup {

    public static DPK03 lookupById(Map<String, DPK03> map, String id) {
        return map.get(id);
    }

    public static void main(String[] args) {
        Map<String, DPK03> dataMap = Map.of(
                "001", new DPK03("001", "Alice"),
                "002", new DPK03("002", "Bob"),
                "003", new DPK03("003", "Charlie")
        );

        String searchId = "002";
        DPK03 result = lookupById(dataMap, searchId);

        if (result != null) {
            System.out.println("Found: " + result);
        } else {
            System.out.println("ID not found: " + searchId);
        }
    }
}

