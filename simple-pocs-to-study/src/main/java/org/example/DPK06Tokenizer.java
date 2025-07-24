package org.example;

import java.util.Arrays;

// Create a function that can tokenize a string based on a token.
public class DPK06Tokenizer {

    public static String[] tokenize(String input, String token) {
        if (input == null || token == null) {
            return new String[0];
        }
        return input.split(java.util.regex.Pattern.quote(token));
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(tokenize("Hello,World,How,Are,You", ",")));
        System.out.println(Arrays.toString(tokenize("Hello World How Are You", " ")));
        System.out.println(Arrays.toString(tokenize("Hello-World-How-Are-You", "-")));
    }
}
