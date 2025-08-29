package org.example;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Data
public class DPK01_impl_5 {

    private static final Map<String, Integer> powerMap = new HashMap<>();

    static {
        powerMap.put("john", 100);
        powerMap.put("paul", 90);
        powerMap.put("george", 80);
        powerMap.put("ringo", 70);
    }

    private static final Map<String, Integer> leaderBoard = new HashMap<>();

    static {
        leaderBoard.put("john", 0);
        leaderBoard.put("paul", 0);
        leaderBoard.put("george", 0);
        leaderBoard.put("ringo", 0);
    }


    public static Integer getPower(String name) {
        return powerMap.getOrDefault(name, null);
    }

    public static String getMostPowerful(String firstName, String secondName) {

        if (powerMap.containsKey(firstName) || powerMap.containsKey(secondName)) {
            Integer firstPlayer = getPower(firstName);
            Integer secondPlayer = getPower(secondName);

            if (firstPlayer == null || secondPlayer == null) {
                return "One or both players not found";
            }

            return (firstPlayer > secondPlayer) ? firstName : secondName;
        }

        return "Both players not found";
    }

    public static Integer getPoints(String name) {
        return leaderBoard.getOrDefault(name, null);
    }

    public static void updateLeaderboard(String name, int points) {
        int newPoints = 0;
        if (leaderBoard.containsKey(name)) {
            int actualPoints = getPoints(name);
            if(points > 0) {
                System.out.println("Adding " + points + " points to " + name);
                newPoints = actualPoints + points;
            } else {
                System.out.println("Removing " + Math.abs(points) + " points from " + name);
                newPoints = actualPoints + points;
            }
            leaderBoard.put(name, newPoints);
        }
        else {
            System.out.println("Person not found in leaderboard");
        }
    }

    public static void main(String[] args) {
        int opcao;

        String firstName = null;
        String secondName = null;

        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("=== DPK05 list system ===");
            System.out.println("1 - Get power of a person");
            System.out.println("2 - Get most powerful person");
            System.out.println("3 - Fight between two persons");
            System.out.println("4 - Get leaderboard");
            System.out.println("5 - exit system");

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

                    firstName = scanner.nextLine().trim().toLowerCase();

                    System.out.println("Choose second person to compare with: " + firstName);

                    secondName = scanner.nextLine().trim().toLowerCase();

                    String result = getMostPowerful(firstName, secondName);
                    System.out.println(result + " is the most powerful between " + firstName + " and " + secondName);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Choose first person to fight (John, Paul, George, Ringo): ");
                    firstName = scanner.nextLine().trim().toLowerCase();

                    System.out.println("Choose first person to fight with: " + firstName);
                    secondName = scanner.nextLine().trim().toLowerCase();

                    String winner = getMostPowerful(firstName, secondName);
                    String loser = firstName.equals(winner) ? secondName : firstName;

                    // Update leaderboard based on the fight result
                    updateLeaderboard(winner, 10);
                    updateLeaderboard(loser, -5);

                    System.out.println("Updated leaderboard: " + leaderBoard);
                    break;
                case 4:
                    System.out.println("Leaderboard: " + leaderBoard);
                    break;
                case 5:
                    System.out.println("---------------------");
                    System.out.println("exiting...");
                    break;
                default:
                    System.out.println("invalid option newbie!");
            }
        }
        while (opcao != 5);
        scanner.close();
    }
}
