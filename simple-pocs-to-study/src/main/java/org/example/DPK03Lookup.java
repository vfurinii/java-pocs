package org.example;

import java.util.Map;

public class DPK03Lookup {

    public static DPK03 lookupById(Map<String, DPK03> map, String id) {
        return map.get(id);
    }

    public static DPK03 lookupByName(Map<String, DPK03> map, String name) {
        return map.values().stream()
                .filter(dpk03 -> dpk03.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public static void main(String[] args) {
        Map<String, DPK03> dataMap = Map.of(
                "001", new DPK03("001", "Alice"),
                "002", new DPK03("002", "Bob"),
                "003", new DPK03("003", "Charlie"),
                "004", new DPK03("004", "Diana"),
                "005", new DPK03("005", "Ethan"),
                "006", new DPK03("006", "Fiona")
        );

        String searchId = "002";
        DPK03 result = lookupById(dataMap, searchId);
        String searchName = "Fiona";
        DPK03 result2 = lookupByName(dataMap, searchName);

        if (result != null) {
            System.out.println("Found: " + result );
        } else {
            System.out.println("ID not found: " + searchId);
        }

        if (result2 != null) {
            System.out.println("Found: " + result2);
        } else {
            System.out.println("Name not found: " + searchId);
        }
    }
}

