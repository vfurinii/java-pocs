package org.example.service;

import org.example.dto.DashBoardResponse;
import org.example.model.Order;
import org.example.model.Payment;
import org.example.model.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class DashboardService {

    private final RestClient restClient;

    public DashboardService(RestClient restClient) {
        this.restClient = restClient;
    }

    public void getDashboard() {

        List<User> users = restClient.get()
                .uri("/users")
                .retrieve()
                .body(new ParameterizedTypeReference<List<User>>() {});

        List<Order> orders = restClient.get()
                .uri("/orders")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Order>>() {});

        List<Payment> payments = restClient.get()
                .uri("/payments")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Payment>>() {});

        new DashBoardResponse(users, payments, orders);

    }
}
