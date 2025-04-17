package org.vitorfurini.kafkapoc.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final String TOPIC = "events-topic";

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        LOGGER.info("Creating a new KafkaProducer");
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(String event) {
        LOGGER.info("Sending event: {}", event);
        this.kafkaTemplate.send(TOPIC, event);
    }
}
