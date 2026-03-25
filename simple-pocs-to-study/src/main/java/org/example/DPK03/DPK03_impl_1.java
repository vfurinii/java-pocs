package org.example.DPK03;

import java.util.HashMap;
import java.util.Map;

//Create a function that perform a lookup in a map for a given key you hould have id, name.
//lookup(1) -> "John"
public class DPK03_impl_1 {

    public static void main(String[] args) {
        Map<Integer, String> idNameMap = new HashMap<>();
        idNameMap.put(1, "John");
        idNameMap.put(2, "Jane");
        idNameMap.put(3, "Doe");

        System.out.println(lookup(idNameMap, 1)); // Output: John
        System.out.println(lookup(idNameMap, 4)); // Output: Key not found
    }

    public static String lookup(Map<Integer, String> idNameMap, Integer id) {
        return idNameMap.getOrDefault(id, "Key not found");
    }
}
