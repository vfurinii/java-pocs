package org.example;

import java.util.ArrayList;
import java.util.List;

//Create a function that can return a list of numbers from 1 to 100.
//For multiples of three return "Fizz" instead of the number and for the multiples of five return "Buzz".
//For numbers which are multiples of both three and five return "FizzBuzz".
public class DPK01_impl_13 {

    static int NUMBERS_UP_TO = 100;

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= NUMBERS_UP_TO; i++) {
            numbers.add(i);
        }
        List<String> result = fizzBuzz(numbers);
        System.out.println(result);
    }

    public static List<String> fizzBuzz(List<Integer> numbers) {

        List<String> result = new ArrayList<>();

        for (Integer n : numbers) {
            if(n % 3 == 0 && n % 5 == 0) {
                result.add("FizzBuzz");
            } else if (n % 3 == 0) {
                 result.add("Fizz");
            } else if (n % 5 == 0) {
                 result.add("Buzz");
            } else {
                result.add(String.valueOf(n));
            }
        }

        return result;
    }
}