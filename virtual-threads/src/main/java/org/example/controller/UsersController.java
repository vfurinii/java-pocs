package org.example.controller;

import org.example.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @GetMapping
    public List<User> getUsers() throws InterruptedException {
        Thread.sleep(1400);

        return List.of(
                new User("Vitor"),
                new User("Maria")
        );
    }
}
