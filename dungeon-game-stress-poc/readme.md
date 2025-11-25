# Dungeon Game Stress PoC

A proof-of-concept project designed to stress test a RESTful Dungeon Game backend using the **Galing** load testing framework, built with **Java 23**, and deployable via **Docker**.

## 🚀 Overview

This project focuses on identifying performance bottlenecks and scalability limits in a dungeon-style game's backend system. It leverages:
- **Java 23** for modern language features and performance
- **Galing** for customizable, scriptable stress testing
- **Docker** for environment consistency
- **REST APIs** as the testing surface

---

## 🧪 Features

- Stress tests REST endpoints exposed by the game server
- Configurable user loads, durations, and concurrency
- Easily extensible test scenarios using Galing
- Containerized execution via Docker
- Metrics/logging output for analysis

---

## 📦 Requirements

- Java 23+
- Docker (for containerized test runs)
- Maven or Gradle (optional, for local development)

---

## ⚙️ Project Structure


🐳 Running with Docker

Build the Docker image:

docker build -t dungeon-stress-poc .

to run k6 tests just run 

-- k6 run k6/standart/script.js
