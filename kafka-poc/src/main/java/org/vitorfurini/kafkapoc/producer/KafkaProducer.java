package org.vitorfurini.kafkapoc.producer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.vitorfurini.kafkapoc.model.EventUser;

@Service
public class KafkaProducer {
    private static final String TOPIC = "events-topic-json";

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    private KafkaTemplate<String, EventUser> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, EventUser> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(EventUser event) {
        LOGGER.info("Sending EventUser: {}", event);
        Message<EventUser> message = MessageBuilder.withPayload(event).setHeader(KafkaHeaders.TOPIC, TOPIC).build();

        kafkaTemplate.send(message);

    }
}
