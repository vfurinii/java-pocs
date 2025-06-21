package org.example;

public class Utility {
    public static String generateId() {
        return "REAL_ID_" + System.currentTimeMillis();
    }

    public static String getMessage() {
        return "test with static method";
    }
}
