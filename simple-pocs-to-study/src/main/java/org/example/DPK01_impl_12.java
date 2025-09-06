package org.example;

//Bubble sort
//Create a function that can sort a list of numbers. The implementation should be a Bubble Sort(good to learn but terrible to use in production).
//The sort function should recive a collection(list or array) and return a new sorted list.
public class DPK01_impl_12 {

    public static void main(String[] args) {
        int[] numbers = {5, 1, 9, 3, 4, 7, 8, 6};
        int size = numbers.length;

        // bubble sort algorithm
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    // swap numbers[j] and numbers[j+1]
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

        //
        System.out.println("Bubble sort result:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}