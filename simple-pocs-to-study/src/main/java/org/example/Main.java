package org.example;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        reverseAndPrint(numbers);

    }

    private static void reverseAndPrint(int[] numbers) {
        System.out.println("Reversed numbers:");
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + ", ");
        }
    }
}