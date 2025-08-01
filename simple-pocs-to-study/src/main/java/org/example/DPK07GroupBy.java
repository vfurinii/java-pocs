package org.example;


import java.util.Objects;

public class DPK07GroupBy {

    //Create a function that can group a list of numbers by a given number.
    //group_by([1,2,3,4,5,6,7,8,9,10], 3) -> [[1,2,3], [4,5,6], [7,8,9], [10]]
   public static String[][] groupBy(String[] items, int groupSize) {
                int numberOfGroups = (int) Math.ceil((double) items.length / groupSize);
                String[][] groupedItems = new String[numberOfGroups][];
            
                for (int i = 0; i < numberOfGroups; i++) {
                    int start = i * groupSize;
                    int end = Math.min(start + groupSize, items.length);
                    groupedItems[i] = new String[end - start];
                    System.arraycopy(items, start, groupedItems[i], 0, end - start);
                }
            
                return groupedItems;
            }

    public static void main(String[] args) {
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] numbers2 = {"11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
        String[] letters = {"a","b","c","d","e","f","g","h","i","j"};
        int groupSize = 3;
        String[][] resultNumbers = groupBy(numbers, groupSize);
        String[][] resultLetters = groupBy(letters, groupSize);
        String[][] resultNumbers2 = groupBy(numbers2, groupSize);
        extracted(resultNumbers);
        System.out.printf("%n");
        extracted(resultLetters);
        System.out.printf("%n");
        extracted(resultNumbers2);
    }

    private static void extracted(String[][] resultNumbers) {
        for (String[] group : resultNumbers) {
            System.out.print("[");
            for (String num : group) {
                if(!Objects.equals(num, group[group.length - 1])) {
                    System.out.print(num + ", ");
                } else {
                    System.out.print(num);
                }
            }
            System.out.print("], ");
        }
    }
}
