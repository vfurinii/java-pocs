package org.order.api.kafka;

import jakarta.inject.Singleton;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Singleton
public class OrderProducer implements AutoCloseable {

    private static final String TOPIC_NAME = "orders.created";

    private final KafkaProducer<String, String> producer;

    public OrderProducer() {

        Properties props = new Properties();

        props.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "localhost:9092"
        );

        props.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName()
        );

        props.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName()
        );

        ensureTopicExists(props);
        producer = new KafkaProducer<>(props);
    }

    public void publish(String json) {

        ProducerRecord<String,String> record =
                new ProducerRecord<>(
                        TOPIC_NAME,
                        json
                );

        try {
            producer.send(record).get();
        } catch (Exception e) {
            throw new RuntimeException("Failed to publish order event", e);
        }
    }

    @Override
    public void close() {
        producer.close();
    }

    private static void ensureTopicExists(Properties props) {
        try (AdminClient adminClient = AdminClient.create(props)) {
            NewTopic topic = new NewTopic(TOPIC_NAME, 1, (short) 1);
            adminClient.createTopics(Collections.singleton(topic))
                    .all()
                    .get(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            // If the topic already exists, we can continue normally.
            if (e.getCause() instanceof org.apache.kafka.common.errors.TopicExistsException) {
                return;
            }
            throw new RuntimeException("Failed to ensure topic exists: " + TOPIC_NAME, e);
        }
    }
}
