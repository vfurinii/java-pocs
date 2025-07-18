package org.example;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Data
public class DPK05Pointers {

    private static final Map<String, Integer> powerMap = new HashMap<>();

    static {
        powerMap.put("john", 100);
        powerMap.put("paul", 90);
        powerMap.put("george", 80);
        powerMap.put("ringo", 70);
    }

    public static Integer getPower(String name) {
        return powerMap.getOrDefault(name, null);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a person you want know the power between John, Paul, George, Ringo: ");
        String name = scanner.nextLine().trim().toLowerCase();

        System.out.println("Power of " + name + ": " + getPower(name));

    }
}
