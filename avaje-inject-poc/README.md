# avaje-inject-poc

Study project to demonstrate [Avaje Inject](https://avaje.io/inject/) in a small producer/consumer architecture.

## What this project shows

- Dependency injection with `@Singleton` and `@Factory`
- Automatic wiring generation by Avaje Inject
- Publishing a JSON event to Kafka
- Consuming the event in a separate process

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

1. Start the broker with:

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

## Main structure

- `src/main/java/org/order/api/Main.java`
- `src/main/java/org/order/api/service/OrderService.java`
- `src/main/java/org/order/api/kafka/OrderProducer.java`
- `src/main/java/notification/service/Main.java`
- `src/main/java/notification/service/kafka/OrderConsumer.java`
- `docker-compose.yml`
