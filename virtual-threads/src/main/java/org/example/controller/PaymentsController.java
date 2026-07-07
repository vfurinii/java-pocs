package org.example.controller;

import org.example.model.Payment;
import org.example.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/payments")
public class PaymentsController {

    @GetMapping
    public List<Payment> getPayment() throws InterruptedException {
        Thread.sleep(1300);

        return List.of(new Payment("Payment"), new Payment("Payment2"));
    }
}
