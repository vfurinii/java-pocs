package org.example;

public class DPK03 {
    private String id;
    private String name;

    public DPK03(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "DPK03{id='" + id + "', name='" + name + "'}";
    }
}
