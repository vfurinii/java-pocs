package org.order.api.kafka;

public record OrderCreatedEvent(
        Long orderId,
        String customer,
        Double amount
) {}
