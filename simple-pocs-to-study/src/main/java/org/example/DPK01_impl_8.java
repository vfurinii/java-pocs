package org.example;

import java.util.Scanner;

//Create a function that can map a function execution to each element of a list, return a new list.
//map([1,2,3,4,5], (x) => x * 2) -> [2,4,6,8,10]
//The map function should recive a collection(list or array) and a function that will be apply to each element of the collection.
//Now refactor the code and do not use any prebuild function.
public class DPK01_impl_8 {

    public static int[] map(int[] input, String operation) {

        int[] result = new int[input.length];

        switch (operation) {
            case "double":
                for (int i = 0; i < input.length; i++) {
                    //multiply by 2
                    result[i] = input[i] * 2;
                }
                return result;
            case "increment":
                for (int i = 0; i < input.length; i++) {
                    //increment by 1
                    result[i] = input[i] + 1;
                }
                return result;
            case "decrement":
                for (int i = 0; i < input.length; i++) {
                    //decrement by 1
                    result[i] = input[i] - 1;
                }
                return result;

            default:
                throw new IllegalArgumentException("Unsupported operation: " + operation);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operation;

        System.out.print("Enter numbers (space-separated): ");

        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        int[] numbers = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);  // Convert and store
        }

        System.out.print("Choose a operation between double, increment, decrement: ");
        operation = scanner.nextLine();

        int[] doubled = map(numbers, operation);
        for (int num : doubled) {
            System.out.print(num + " ");
        }
    }
}
