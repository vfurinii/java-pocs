package org.example;

import lombok.Data;

@Data
public class Countries {

    private String id;
    private String name;
    private String language;

    public Countries(String name, String language) {
        this.name = name;
        this.language = language;
    }

    @Override
    public String toString() {
        return "Countries{name='" + name + "', language='" + language + "'}";
    }
}
