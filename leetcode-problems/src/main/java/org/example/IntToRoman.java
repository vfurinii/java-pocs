package org.example;


/*
* Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
* */

public class IntToRoman {

    static int[] values = {1000, 500, 100, 50, 10, 5, 1};
    static String[] symbols = {"M", "D", "C", "L", "X", "V", "I"};

    static String convert(int number) {

        String romanNumber = "";

        for (int i = 0; i < values.length; i++) {

            while (number >= values[i]) {
                number -= values[i];
                romanNumber += symbols[i];
            }

        }
        return romanNumber;
    }

    public static void main(String[] args) {
        System.out.println(convert(151));
        System.out.println(convert(2025));  // MMXXV
        System.out.println(convert(3000));  // MMM
    }
}
