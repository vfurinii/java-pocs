package org.example.DPK05;

import java.util.HashMap;
import java.util.Map;

public class DPK05_impl_2 {

    private static final Map<String, Integer> power = new HashMap<>();

        static {
            power.put("John", 100);
            power.put("Paul", 90);
            power.put("George", 80);
            power.put("Ringo", 70);
        }

        public static int getPower(String name) {
            return power.getOrDefault(name, 0);
        }

        public static String getMostPowerful(String name1, String name2) {
            int power1 = getPower(name1);
            int power2 = getPower(name2);

            if (power1 > power2) {
                return name1;
            } else if (power2 > power1) {
                return name2;
            } else {
                return "Tie";
            }
        }

        public static void main(String[] args) {
            System.out.println(getMostPowerful("John", "Paul")); // John
        }
}
