package notification.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class Main {

    public static void main(String[] args) {
        long startedAt = System.nanoTime();
        SpringApplication.run(Main.class, args);
        long readyAt = System.nanoTime();
        System.out.printf("Spring Boot consumer ready in %.2f ms%n", elapsedMillis(startedAt, readyAt));
    }

    private static double elapsedMillis(long startedAt, long finishedAt) {
        return (finishedAt - startedAt) / 1_000_000.0;
    }
}
