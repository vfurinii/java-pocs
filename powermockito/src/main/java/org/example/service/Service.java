package org.example.service;

import org.example.utils.Utils;

public class Service {
    public String process() {
        String time = Utils.getTimestamp();
        return "processed when " + time;
    }
}
