package org.order.api.kafka;

import jakarta.inject.Singleton;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

@Singleton
public class OrderProducer {

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

        producer = new KafkaProducer<>(props);
    }

    public void publish(String json) {

        ProducerRecord<String,String> record =
                new ProducerRecord<>(
                        "orders.created",
                        json
                );

        producer.send(record);
    }
}
