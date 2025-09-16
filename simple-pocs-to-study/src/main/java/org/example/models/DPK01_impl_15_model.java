package org.example.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DPK01_impl_15_model {

    private String name;
    private int age;
    private List<String> friends;

    public DPK01_impl_15_model(String name, int age) {
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
    }

    public void addFriend(String friend) {
        this.friends.add(friend);
    }


    public void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Friends: " + friends);
    }

    public void showAge() {
        System.out.println("Age: " + age);
    }

    public void giveName() {
        System.out.println("Name: " + name);
    }
}
