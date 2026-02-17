package org.example.DPK02;

public class DPK02_impl_1 {

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
}
