# springboot-inject-poc

Spring Boot version of the Avaje Inject proof of concept.

## What this project shows

- Dependency injection with Spring Boot
- Producer and consumer separation
- Publishing a JSON event to Kafka
- Consuming the event in a separate process
- Startup timing printed by both applications

## Demo flow

1. `org.order.api.Main` creates an order and publishes an event to the `orders.created` topic
2. `notification.service.Main` consumes the event from the same topic and prints the payload to the console

## Requirements

- Java 25
- Maven 3.9+
- Kafka available at `localhost:9092`

## Validate the project

```bash
mvn test
```

## How to run

1. Start the broker:

```bash
docker compose up -d
```

2. Run the consumer:

```bash
mvn -q -Dexec.mainClass=notification.service.Main exec:java
```

3. In another terminal, run the producer:

```bash
mvn -q -Dexec.mainClass=org.order.api.Main exec:java
```

4. Observe the event arriving in the consumer console

## Timing

- Each application prints its own startup time in milliseconds
- The producer also prints the total time until the event is published
- To measure build time, use:

```bash
/usr/bin/time -p mvn -DskipTests package
```

## Main structure

- `src/main/java/org/order/api/Main.java`
- `src/main/java/org/order/api/service/OrderService.java`
- `src/main/java/org/order/api/kafka/OrderProducer.java`
- `src/main/java/notification/service/Main.java`
- `src/main/java/notification/service/kafka/OrderConsumer.java`
- `docker-compose.yml`
