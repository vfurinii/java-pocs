package org.example.service;

import org.example.Utility;

public class UserService {
    public String createUser() {
        return "USER_" + Utility.generateId();
    }

    public String process() {
        return Utility.getMessage();
    }
}
