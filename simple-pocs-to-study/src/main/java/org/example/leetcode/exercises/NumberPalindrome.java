package org.example.leetcode.exercises;

public class NumberPalindrome {

    public static Boolean isPalindrome(int x) {

        String palindrome = String.valueOf(x);
        String reversed = new StringBuilder(palindrome).reverse().toString();

        return palindrome.equalsIgnoreCase(reversed);
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome(101));
    }
}
