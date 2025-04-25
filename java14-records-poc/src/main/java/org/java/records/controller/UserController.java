package org.java.records.controller;

import org.java.records.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author vfurini
 */
@RestController
public class UserController {

    @GetMapping("/")
    public String greetings() {
        return "Hello World";
    }

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return List.of(
                new User(1, "Vitor", "vitorfurini@hotmail.com"),
                new User(2, "John", "john@hotmail.com"),
                new User(3, "Doe", "doe@hotmail.com")
        );
    }


}
