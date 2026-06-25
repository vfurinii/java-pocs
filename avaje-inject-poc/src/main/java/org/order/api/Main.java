package org.order.api;

import io.avaje.inject.BeanScope;
import org.order.api.service.OrderService;

public class Main {
    public static void main(String[] args) throws Exception {
        long startedAt = System.nanoTime();

        try (BeanScope scope = BeanScope.builder().build()) {
            long readyAt = System.nanoTime();
            System.out.printf("Avaje producer ready in %.2f ms%n", elapsedMillis(startedAt, readyAt));

            OrderService service = scope.get(OrderService.class);
            service.createOrder();

            long completedAt = System.nanoTime();
            System.out.printf("Avaje producer completed in %.2f ms%n", elapsedMillis(startedAt, completedAt));
        }
    }

    private static double elapsedMillis(long startedAt, long finishedAt) {
        return (finishedAt - startedAt) / 1_000_000.0;
    }
}
