package org.java;

import org.springframework.stereotype.Service;

@Service
public class IntegrationService {

    public String getHello(String name) {
        return "Hello, " + name + "!";
    }
}
