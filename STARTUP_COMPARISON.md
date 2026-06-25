# Startup Comparison

This workspace contains two equivalent projects:

- `avaje-inject-poc`
- `springboot-inject-poc`

## Latest comparison

Measured on June 25, 2026 on the local machine using the `compare-startup.sh` script.

| Project | Build time | Consumer ready | Producer ready | Producer completed |
| --- | ---: | ---: | ---: | ---: |
| Avaje Inject | 1.52 s | 192.33 ms | 204.68 ms | 288.12 ms |
| Spring Boot | 1.73 s | 721.16 ms | 774.86 ms | 846.95 ms |

## What to compare

- Build time
- Application startup time
- Time until the producer publishes the event
- Time until the consumer is ready to receive events

## Build time

The comparison script runs the following command inside each project directory:

```bash
/usr/bin/time -p mvn -DskipTests package
```

## Runtime timing

Both projects print startup timing in milliseconds when you run their main classes.

### Avaje project

```bash
cd avaje-inject-poc
mvn -q -Dexec.mainClass=notification.service.Main exec:java
mvn -q -Dexec.mainClass=org.order.api.Main exec:java
```

### Spring Boot project

```bash
cd springboot-inject-poc
mvn -q -Dexec.mainClass=notification.service.Main exec:java
mvn -q -Dexec.mainClass=org.order.api.Main exec:java
```

## Notes

- Use `./compare-startup.sh` from the workspace root to run both projects with one shared broker.
- The script reuses any broker already listening on port `9092`.
- The producer prints both the time to become ready and the total time until the event is published.
- The consumer prints the time until it is ready to listen for Kafka messages.
