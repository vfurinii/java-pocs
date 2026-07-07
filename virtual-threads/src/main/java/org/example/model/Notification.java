package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notification {
    private String name;

    public Notification(String name) {
        this.name = name;
    }
}
