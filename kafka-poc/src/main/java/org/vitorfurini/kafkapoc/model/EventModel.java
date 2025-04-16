package org.vitorfurini.kafkapoc.model;

import lombok.Data;

@Data
public class EventModel {

    private String id;
    private String type;
    private String payload;

    public EventModel(String id, String type, String payload) {
        this.id = id;
        this.type = type;
        this.payload = payload;
    }
}
