package org.example;

import java.util.Map;

public class SimplePatternMatcherPOC {
    public static void main(String[] args) {
        Map<String, Countries> dataMap = Map.of(
                "001", new Countries("USA", "english"),
                "002", new Countries("Brazil", "Portuguese"),
                "003", new Countries("Spain", "Spanish"),
                "004", new Countries("Italy", "Italian"),
                "005", new Countries("France", "French"),
                "006", new Countries("Germany", "German")
        );

        String name = "Brazil";

        for(Map.Entry<String, Countries> entry : dataMap.entrySet()) {
            if (entry.getValue().getName().equalsIgnoreCase(name)) {
                System.out.println("Found: " + entry.getValue().getLanguage());
            }
        }
    }
}
