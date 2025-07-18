package org.example.models;

public class DPK05 {
    private String power;
    private String name;

    public DPK05(String power, String name) {
        this.power = power;
        this.name = name;
    }
    public String getId() {
        return power;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "DPK05{power='" + power + "', name='" + name + "'}";
    }
}
