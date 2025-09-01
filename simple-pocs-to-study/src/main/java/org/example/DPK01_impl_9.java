package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Create a function that can filter a list based on a given condition.

//filter([1,2,3,4,5,6,7,8,9,10], (x) => x % 2 == 0) -> [2,4,6,8,10]
//The filter function should recive a collection(list or array) and a function that will be apply to each element of the collection.
//
//Now refactor the code and do not use any prebuild function.
interface Condition {
    boolean test(int x);
}

public class DPK01_impl_9 {

    public static List<Integer> filter(List<Integer> collection, Condition condition) {
        List<Integer> result = new ArrayList<>();
        for (int item : collection) {
            if (condition.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        List<Integer> evenNumbers = filter(numbers, x -> x % 2 == 0);

        System.out.println(evenNumbers);
    }
}