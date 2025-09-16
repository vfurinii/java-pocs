package org.example;

import org.example.models.DPK01_impl_15_model;

//Create a class that can represent a person. The person should have a name, age and a list of friends.
public class DPK_01_impl_15 {

    public static void main(String[] args) {
        DPK01_impl_15_model person = new DPK01_impl_15_model("Vitor", 30);
        person.addFriend("Bob");
        person.addFriend("Charlie");
        person.addFriend("Gabriela");
        person.addFriend("Vicenzo");
        person.showInfo();
//        person.showAge();
//        person.giveName();
    }
}
