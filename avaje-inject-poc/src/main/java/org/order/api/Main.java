package org.order.api;

import io.avaje.inject.BeanScope;
import org.order.api.service.OrderService;

public class Main {
    public static void main(String[] args) throws Exception {
        try (BeanScope scope = BeanScope.builder().build()) {
            OrderService service = scope.get(OrderService.class);
            service.createOrder();
        }
    }
}
