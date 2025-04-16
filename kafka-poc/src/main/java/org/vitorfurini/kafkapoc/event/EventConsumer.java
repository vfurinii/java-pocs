package org.vitorfurini.kafkapoc.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.vitorfurini.kafkapoc.model.EventModel;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class EventConsumer {
    private static final String TOPIC = "events-topic";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "event-consumers");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());
        props.put("auto.offset.reset", "earliest");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        ObjectMapper mapper = new ObjectMapper();

        consumer.subscribe(Collections.singletonList(TOPIC));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));

            for (ConsumerRecord<String, String> record : records) {
                try {
                    EventModel event = mapper.readValue(record.value(), EventModel.class);
                    System.out.println("Event received: " + event);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
