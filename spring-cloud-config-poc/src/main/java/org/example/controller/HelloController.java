package org.example.controller;

import org.example.config.MyAppConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final MyAppConfig config;

    public HelloController(MyAppConfig config) {
        this.config = config;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return config.getGreeting() + ", " + config.getName() + "!";
    }
}
