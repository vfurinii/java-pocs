package org.order.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.order.api.kafka.OrderCreatedEvent;
import org.order.api.kafka.OrderProducer;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderProducer producer;
    private final ObjectMapper mapper;

    public OrderService(OrderProducer producer, ObjectMapper mapper) {
        this.producer = producer;
        this.mapper = mapper;
    }

    public void createOrder() {
        OrderCreatedEvent event = new OrderCreatedEvent(1L, "Vitor", 499.99);

        try {
            String json = mapper.writeValueAsString(event);
            producer.publish(json);
            System.out.println("Event published");
        } catch (Exception e) {
            throw new RuntimeException("Failed to create order event", e);
        }
    }
}
