package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

//DPK10 Reduce
//Create a function that can reduce a list to a single value.
//The reduce function should recive a collection(list or array), a function that will be apply to each element of the collection and an initial value.
//
//Now refactor the code and do not use any prebuild function.
public class DPK01_impl_10 {

    //<T, R> generic types
    //T - type of elements in the list
    //R - type of the result
    //BiFunction<R, T, R> - a function that takes two arguments (R and T) and returns a value of type R
    public static <T, R> R reduce(List<T> list, BiFunction<R, T, R> reducer, R initial) {

        R result = initial;
        for (T item : list) {
            result = reducer.apply(result, item);
        }
        return result;
    }

    public static <T, R> R filter(List<T> list, BiFunction<R, T, R> filter, R initial) {

        R result = initial;
        for (T item : list) {
            result = filter.apply(result, item);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sum = reduce(numbers, (acc, x) -> acc + x, 0);

        int evenSum = filter(numbers, (acc, x) -> {
            if (x % 2 == 0) {
                return acc + x;
            }
            return acc;
        }, 0);

        System.out.println(sum);
        System.out.println(evenSum);
    }
}