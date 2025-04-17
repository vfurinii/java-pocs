package org.vitorfurini.kafkapoc.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EventConsumer {
    private static final String TOPIC = "events-topic";

    private static final Logger LOGGER = LoggerFactory.getLogger(EventConsumer.class);

    @KafkaListener(topics = TOPIC, groupId = "event-consumers")
    public void listen(String message) {
        LOGGER.info("Received message: {}", message);
    }
}
