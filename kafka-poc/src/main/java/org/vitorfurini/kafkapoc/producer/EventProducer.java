package org.vitorfurini.kafkapoc.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.*;
import org.vitorfurini.kafkapoc.model.EventModel;

import java.util.Properties;
import java.util.UUID;

public class EventProducer {
    private static final String TOPIC = "events-topic";

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        ObjectMapper mapper = new ObjectMapper();

        EventModel event = new EventModel(UUID.randomUUID().toString(), "USER_CREATED", "User John Doe created");
        String json = mapper.writeValueAsString(event);

        ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, event.getId(), json);
        producer.send(record, (metadata, exception) -> {
            if (exception != null) {
                exception.printStackTrace();
            } else {
                System.out.println("Event sent: " + json);
            }
        });

        producer.close();
    }
}
