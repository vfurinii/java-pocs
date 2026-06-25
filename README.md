# java-pocs

Workspace for small Java proof-of-concept projects.

## Avaje Inject vs Spring Boot

This workspace contains two equivalent Kafka-based applications:

- [avaje-inject-poc](/Users/vitorfurini/IdeaProjects/java-pocs/avaje-inject-poc)
- [springboot-inject-poc](/Users/vitorfurini/IdeaProjects/java-pocs/springboot-inject-poc)

They implement the same flow:

1. A producer publishes an `OrderCreatedEvent` to `orders.created`
2. A consumer reads the event and prints it to the console

## Presentation goal

This workspace is designed to help explain the practical difference between Avaje Inject and Spring Boot in a small, realistic Kafka example.

The comparison focuses on:

- Build time
- Startup time
- Time to become ready
- Time to publish and consume one event

## Current takeaway

In the latest local run, Avaje Inject started faster than Spring Boot in this sample.

- Avaje consumer ready: `192.33 ms`
- Spring Boot consumer ready: `721.16 ms`
- Avaje producer completed: `288.12 ms`
- Spring Boot producer completed: `846.95 ms`

The full table is documented in [STARTUP_COMPARISON.md](/Users/vitorfurini/IdeaProjects/java-pocs/STARTUP_COMPARISON.md).

## Benchmarking

Use the comparison script from the workspace root:

```bash
./compare-startup.sh
```

The script measures:

- Build time
- Consumer startup time
- Producer startup time
- Producer completion time

Recommended presentation flow:

1. Show the Avaje project first and explain the generated wiring
2. Run the benchmark script to capture timings
3. Show the Spring Boot version with the same business flow
4. Compare the table and discuss the tradeoffs

## What to open during the demo

- [Benchmark summary](/Users/vitorfurini/IdeaProjects/java-pocs/STARTUP_COMPARISON.md)
- [Avaje README](/Users/vitorfurini/IdeaProjects/java-pocs/avaje-inject-poc/README.md)
- [Spring Boot README](/Users/vitorfurini/IdeaProjects/java-pocs/springboot-inject-poc/README.md)

## Notes

- The two projects share the same Kafka broker on port `9092`.
- Start from the workspace root if you want a single place to compare them side by side.
- If you are presenting live, keep the terminal with the benchmark script visible so the startup times are easy to compare.
