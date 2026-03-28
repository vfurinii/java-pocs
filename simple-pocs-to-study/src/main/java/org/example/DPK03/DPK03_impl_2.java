package org.example.DPK03;

import java.util.Map;

public class DPK03_impl_2 {

    public static String lookup(Map<Integer, String> idNameMap, Integer id) {
        for (Map.Entry<Integer, String> entry : idNameMap.entrySet()) {
            if (entry.getKey().equals(id)) {
                return entry.getValue();
            }
        }
        return "Key not found";
    }
}
