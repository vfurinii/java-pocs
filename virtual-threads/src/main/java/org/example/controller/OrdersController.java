package org.example.controller;

import org.example.model.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrdersController {

    @GetMapping
    public List<Order> getOrder() throws InterruptedException {
        Thread.sleep(1200);

        return List.of(new Order("Order"), new Order("Order 2"));
    }
}
