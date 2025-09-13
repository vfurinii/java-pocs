# Spring Boot + PostgreSQL + Docker Compose POC

This project is a simple **Proof of Concept (POC)** that shows how to run a **Spring Boot REST API** inside Docker, connected to a **PostgreSQL database** using Docker Compose.

---

## 🛠 Technologies
- [Java 23 (Amazon Corretto)](https://aws.amazon.com/corretto/)
- [Spring Boot 3](https://spring.io/projects/spring-boot)
- [PostgreSQL 16](https://hub.docker.com/_/postgres)
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

---

## 📂 Project Structure
├── src/main/java/com/example/demo
│ ├── DemoApplication.java # Main Spring Boot application
│ ├── User.java # Entity example
│ ├── UserRepository.java # Spring Data JPA repository
│ └── UserController.java # REST controller
├── pom.xml # Maven dependencies
├── Dockerfile # Docker image for Spring Boot
├── docker-compose.yml # Orchestration file (App + PostgreSQL)
└── README.md # Documentation


---

## ⚡ Getting Started

### 1. Build the JAR
```bash
./mvnw clean package -DskipTests

Start containers
docker-compose up --build

The Spring Boot app will be available at:
👉 http://localhost:8080

PostgreSQL will run at:
👉 localhost:5432 (user: postgres, password: postgres, db: mydb)

🔎 API Endpoints
Create a User

curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{"name":"Vitor"}'

curl http://localhost:8080/users

[
  {
    "id": 1,
    "name": "Vitor"
  }
]


⚙️ Environment Variables
SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/mydb
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=postgres
SPRING_JPA_HIBERNATE_DDL_AUTO=update

📦 Useful Commands
Rebuild and restart containers:
docker-compose up --build

Stop containers:
docker-compose down

Remove volumes (⚠️ deletes DB data):
docker-compose down -v

Check logs:
docker-compose logs -f app

📝 License

This POC is for learning and demonstration purposes.

---

Do you want me to also **extend this README with a section about running with pgAdmin** (so you can easily inspect the database via browser)?




