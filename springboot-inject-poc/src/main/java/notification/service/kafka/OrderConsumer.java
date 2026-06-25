package notification.service.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.order.api.kafka.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    private final ObjectMapper mapper;

    public OrderConsumer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @KafkaListener(topics = "orders.created", groupId = "notification-service")
    public void listen(String payload) {
        try {
            OrderCreatedEvent event = mapper.readValue(payload, OrderCreatedEvent.class);
            System.out.printf(
                    "Order received: id=%d customer=%s amount=%.2f%n",
                    event.orderId(),
                    event.customer(),
                    event.amount()
            );
        } catch (Exception e) {
            System.out.println("Failed to read event: " + e.getMessage());
        }
    }
}
