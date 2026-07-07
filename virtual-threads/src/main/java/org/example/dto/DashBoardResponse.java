package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.model.Order;
import org.example.model.Payment;
import org.example.model.User;

import java.util.List;

@Data
@AllArgsConstructor
public class DashBoardResponse {

    public List<User> users;
    public List<Payment> payment;
    public List<Order> order;
}
