package org.example.DPK01;

//Create a function that can revert a string.
public class DPK01_impl_1 {

    public static String revertString(String str){
        if (str == null) {
            return null;
        }
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }
}
