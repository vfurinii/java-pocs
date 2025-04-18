package org.vitorfurini.kafkapoc.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.vitorfurini.kafkapoc.model.EventUser;

@Service
public class EventConsumer {
    private static final String TOPIC = "events-topic";

    private static final Logger LOGGER = LoggerFactory.getLogger(EventConsumer.class);

    @KafkaListener(topics = TOPIC, groupId = "event-consumers")
    public void listen(EventUser message) {
        LOGGER.info("Received message: {}", message);
    }
}
