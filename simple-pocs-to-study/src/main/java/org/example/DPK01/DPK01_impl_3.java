package org.example.DPK01;

public class DPK01_impl_3 {

    public static void main(String[] args) {
        String test = "messi";
        System.out.println(revert(test));
    }

    public static String revert(String input){
        if (null == input){
            return null;
        }
        String result = "";
        char[] chars = input.toCharArray();
        for(int i=input.length()-1; i >= 0; i--){
            result += chars[i];
        }
        return result;
    }
}
