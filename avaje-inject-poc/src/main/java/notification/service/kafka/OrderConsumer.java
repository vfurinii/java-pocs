package notification.service.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Singleton;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.order.api.kafka.OrderCreatedEvent;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

@Singleton
public class OrderConsumer implements AutoCloseable {

    private final KafkaConsumer<String, String> consumer;
    private final ObjectMapper mapper;

    public OrderConsumer(ObjectMapper mapper) {
        this.mapper = mapper;

        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "notification-service");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        consumer = new KafkaConsumer<>(props);
        consumer.subscribe(List.of("orders.created"));
    }

    public void listen() {
        System.out.println("Waiting for events on orders.created...");

        while (!Thread.currentThread().isInterrupted()) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));

            records.forEach(record -> {
                try {
                    OrderCreatedEvent event = mapper.readValue(record.value(), OrderCreatedEvent.class);
                    System.out.printf(
                            "Order received: id=%d customer=%s amount=%.2f%n",
                            event.orderId(),
                            event.customer(),
                            event.amount()
                    );
                } catch (Exception e) {
                    System.out.println("Failed to read event: " + e.getMessage());
                }
            });
        }
    }

    @Override
    public void close() {
        consumer.close();
    }
}
