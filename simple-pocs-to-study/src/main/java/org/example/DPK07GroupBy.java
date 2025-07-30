package org.example;


public class DPK07GroupBy {

    //Create a function that can group a list of numbers by a given number.
    //group_by([1,2,3,4,5,6,7,8,9,10], 3) -> [[1,2,3], [4,5,6], [7,8,9], [10]]
    public static int[][] groupBy(int[] numbers, int groupSize) {
        int numberOfGroups = (int) Math.ceil((double) numbers.length / groupSize);
        int[][] groupedNumbers = new int[numberOfGroups][];

        for (int i = 0; i < numberOfGroups; i++) {
            int start = i * groupSize;
            int end = Math.min(start + groupSize, numbers.length);
            groupedNumbers[i] = new int[end - start];
            System.arraycopy(numbers, start, groupedNumbers[i], 0, end - start);
        }

        return groupedNumbers;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //TODO
        String[] letters = {"a","b","c","d","e","f","g","h","i","j"};
        int groupSize = 3;
        int[][] result = groupBy(numbers, groupSize);

        for (int[] group : result) {
            System.out.print("[");
            for (int num : group) {
                if(num != group[group.length - 1]) {
                    System.out.print(num + ", ");
                } else {
                    System.out.print(num);
                }
            }
            System.out.print("], ");
        }
    }
}
