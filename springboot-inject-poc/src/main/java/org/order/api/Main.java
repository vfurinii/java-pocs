package org.order.api;

import org.order.api.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        long startedAt = System.nanoTime();

        try (ConfigurableApplicationContext context = SpringApplication.run(Main.class, args)) {
            long readyAt = System.nanoTime();
            System.out.printf("Spring Boot producer ready in %.2f ms%n", elapsedMillis(startedAt, readyAt));

            OrderService service = context.getBean(OrderService.class);
            service.createOrder();

            long completedAt = System.nanoTime();
            System.out.printf("Spring Boot producer completed in %.2f ms%n", elapsedMillis(startedAt, completedAt));
        }
    }

    private static double elapsedMillis(long startedAt, long finishedAt) {
        return (finishedAt - startedAt) / 1_000_000.0;
    }
}
