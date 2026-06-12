# avaje-inject-poc

Projeto de estudo para demonstrar o uso do [Avaje Inject](https://avaje.io/inject/) em uma pequena arquitetura com produtor e consumidor.

## O que este projeto mostra

- Injeção de dependências com `@Singleton` e `@Factory`
- Geração automática de wiring pelo Avaje Inject
- Publicação de evento JSON em Kafka
- Consumo do evento em outro processo

## Fluxo da demo

1. `org.order.api.Main` cria um pedido e publica um evento no tópico `orders.created`
2. `notification.service.Main` consome o evento do mesmo tópico e imprime o conteúdo no console

## Requisitos

- Java 25
- Maven 3.9+
- Kafka disponível em `localhost:9092`

## Validar o projeto

```bash
mvn test
```

## Como executar

1. Suba o broker com:

```bash
docker compose up -d
```

2. Execute o consumer:

```bash
mvn -q -Dexec.mainClass=notification.service.Main exec:java
```

3. Em outro terminal, execute o producer:

```bash
mvn -q -Dexec.mainClass=org.order.api.Main exec:java
```

4. Observe o evento chegando no console do consumer

## Estrutura principal

- `src/main/java/org/order/api/Main.java`
- `src/main/java/org/order/api/service/OrderService.java`
- `src/main/java/org/order/api/kafka/OrderProducer.java`
- `src/main/java/notification/service/Main.java`
- `src/main/java/notification/service/kafka/OrderConsumer.java`
- `docker-compose.yml`
