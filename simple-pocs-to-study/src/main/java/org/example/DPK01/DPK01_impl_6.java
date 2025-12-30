package org.example.DPK01;

public class DPK01_impl_6 {

    public static String revert(String input) {

        if (null == input) return null;
        StringBuilder result = new StringBuilder();
        for (int i = input.length()-1;i>=0;i--){
            result.append(input.toCharArray()[i]);
        }
        return result.toString();
    }
}
