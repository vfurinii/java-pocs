package org.example.controller;

import org.example.model.Card;
import org.example.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cards")
public class CardsController {

    @GetMapping
    public Card getCard() throws InterruptedException {
        Thread.sleep(1100);

        return new Card("Vitor");
    }
}
