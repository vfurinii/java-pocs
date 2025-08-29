package org.example;

import java.util.Scanner;

public class DPK01_impl_4 {

    public static String pattern_matcher(String country) {
        switch (country.toUpperCase()) {
            case "USA":
                return "English";
            case "BRAZIL":
                return "Portuguese";
            case "SPAIN":
                return "Spanish";
            case "ITALY":
                return "Italian";
            case "FRANCE":
                return "French";
            case "GERMANY":
                return "German";
            default:
                return "Unknown Country";
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a country you want know the language between Usa, Brazil, Spain, Italy, France, Germany: ");

        String country = scanner.nextLine();

        String language = pattern_matcher(country);
        System.out.println(country.toUpperCase() + " > " + language);
    }
}
