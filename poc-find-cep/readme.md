# 📦 POC - Find CEP (Brazilian Zip Code)

This is a simple Java proof-of-concept (POC) project to demonstrate how to find address information using a Brazilian CEP (postal code) via an external API.

---

## 🔍 Features

- Search for Brazilian addresses by CEP
- Integration with public [ViaCEP API](https://viacep.com.br/)
- Uses Java 17, Spring Boot, and WebClient for HTTP communication
- Clean and simple structure for educational purposes

---

## 🛠️ Technologies

- Java 17
- Spring Boot 3
- Spring WebFlux (WebClient)
- Maven

---

## 🚀 How to Run

### Prerequisites

- Java 17+
- Maven 3.8+

### Steps

```bash
# Clone the repository
git clone https://github.com/vfurinii/java-pocs.git
cd java-pocs/poc-find-cep

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```
### 📬 Example Usage
http://localhost:8080/cep/{cep}

### Example Request
curl http://localhost:8080/cep/01001000

### Example Response
```json
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "complemento": "lado ímpar",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP",
  "ibge": "3550308",
  "gia": "1004",
  "ddd": "11",
  "siafi": "7107"
}
```

### 📁 Project Structure
```plaintext
poc-find-cep
├── src
│   └── main
│       ├── java
│       │   └── com.example.pocfindcep
│       │       ├── controller
│       │       ├── service
│       │       └── model
│       └── resources
│           └── application.yml
├── pom.xml
└── README.md

