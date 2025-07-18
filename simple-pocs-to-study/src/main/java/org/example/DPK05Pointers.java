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

    public static String getMostPowerfull(String firstName, String secondName) {

        if (powerMap.containsKey(firstName) || powerMap.containsKey(secondName)) {
            Integer firstPlayer = powerMap.get(firstName);
            Integer secondPlayer = powerMap.get(secondName);

            if (firstPlayer == null || secondPlayer == null) {
                return "One or both players not found";
            }

            return (firstPlayer > secondPlayer)
                    ? firstName + " is more powerful"
                    : secondName + " is more powerful";
        }

        return "Both players not found";
    }

    public static void main(String[] args) {
        int opcao;

        Scanner scanner = new Scanner(System.in);



            System.out.println("=== DPK05 list system ===");
            System.out.println("1 - Get power of a person");
            System.out.println("2 - Get most powerful person");
            System.out.println("3 - exit system");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Choose a person you want know the power between John, Paul, George, Ringo: ");
                    String name = scanner.nextLine().trim().toLowerCase();

                    System.out.println("Power of " + name + ": " + getPower(name));
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Choose first person to compare their power (John, Paul, George, Ringo): ");

                    String firstName = scanner.nextLine().trim().toLowerCase();

                    System.out.println("Choose second person to compare with: " + firstName);

                    String secondName = scanner.nextLine().trim().toLowerCase();

                    String result = getMostPowerfull(firstName, secondName);
                    System.out.println(result);
                case 3:
                    System.out.println("---------------------");
                    System.out.println("exiting...");
                    break;
                default:
                    System.out.println("invalid option newbie!");
            }
        scanner.close();
    }
}
