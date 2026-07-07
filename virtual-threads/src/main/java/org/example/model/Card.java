package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {
    private String name;

    public Card(String name) {
        this.name = name;
    }
}
