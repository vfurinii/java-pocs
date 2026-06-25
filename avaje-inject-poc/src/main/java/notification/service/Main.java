package notification.service;

import io.avaje.inject.BeanScope;
import notification.service.kafka.OrderConsumer;

public class Main {

    public static void main(String[] args) {
        long startedAt = System.nanoTime();

        try (BeanScope scope = BeanScope.builder().build()) {
            long readyAt = System.nanoTime();
            System.out.printf("Avaje consumer ready in %.2f ms%n", elapsedMillis(startedAt, readyAt));

            OrderConsumer consumer = scope.get(OrderConsumer.class);
            consumer.listen();
        }
    }

    private static double elapsedMillis(long startedAt, long finishedAt) {
        return (finishedAt - startedAt) / 1_000_000.0;
    }
}
