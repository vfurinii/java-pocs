package org.example.DPK11;


//Create a function that can replace a given token in a string.
//
//replace("Hello,World,How,Are,You", ",", "-") -> "Hello-World-How-Are-You"
public class DPK11_impl_1 {

    String replace(String input, String token, String replacement) {
        return input.replace(token, replacement);
    }

        public static void main(String[] args) {
            DPK11_impl_1 dpk11 = new DPK11_impl_1();
            String result = dpk11.replace("Hello,World,How,Are,You", ",World,", "-");
            System.out.println(result);
        }
}
