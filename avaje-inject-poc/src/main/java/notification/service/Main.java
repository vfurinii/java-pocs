package notification.service;

import io.avaje.inject.BeanScope;
import notification.service.kafka.OrderConsumer;

public class Main {

    public static void main(String[] args) {
        try (BeanScope scope = BeanScope.builder().build()) {
            OrderConsumer consumer = scope.get(OrderConsumer.class);
            consumer.listen();
        }
    }
}
