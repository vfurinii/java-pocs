package org.order.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Singleton;
import org.order.api.kafka.OrderCreatedEvent;
import org.order.api.kafka.OrderProducer;

@Singleton
public class OrderService {

    private final OrderProducer producer;

    private final ObjectMapper mapper;

    public OrderService(
            OrderProducer producer,
            ObjectMapper mapper) {

        this.producer = producer;
        this.mapper = mapper;
    }

    public void createOrder() throws Exception {

        OrderCreatedEvent event =
                new OrderCreatedEvent(
                        1L,
                        "Vitor",
                        499.99
                );

        String json =
                mapper.writeValueAsString(event);

        producer.publish(json);

        System.out.println(
                "Evento publicado"
        );
    }
}
