package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ConfigPocApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigPocApplication.class, args);
    }
}