package org.example;

import java.util.Scanner;

//Create a function that can replace a given token in a string.
//
//replace("Hello,World,How,Are,You", ",", "-") -> "Hello-World-How-Are-You"
//The replace function should recive a string, a token to be replaced and a new token. Refactor the code to not only replace one token but a string that you can recive by parameter.
public class DPK01_impl_11 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String str = scanner.nextLine();

        System.out.println("Enter the token to be replaced:");
        String tokenToReplace = scanner.nextLine();
        System.out.println("Enter the new token:");
        String newToken = scanner.nextLine();
        String result = replace(str, tokenToReplace, newToken);
        System.out.println(result);

    }
    public static String replace(String str, String tokenToReplace, String newToken) {
        return str.replace(tokenToReplace, newToken);
    }
}