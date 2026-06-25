# ☕ Java POCs

Uma coleção de **Proofs of Concept (POCs)** desenvolvidas em Java para estudar, validar e demonstrar diferentes tecnologias, frameworks, padrões arquiteturais e boas práticas utilizadas no desenvolvimento moderno de software.

O objetivo deste repositório é servir como um laboratório de experimentação, permitindo testar novas tecnologias de forma isolada antes de utilizá-las em projetos reais.

## 🚀 Tecnologias

Dependendo da POC, podem ser utilizados:

- Java 17+
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- Maven
- Docker
- Testcontainers
- JUnit 5
- Mockito
- Kafka
- Redis
- PostgreSQL
- MySQL
- AWS
- Kubernetes
- OpenAPI / Swagger
- REST APIs
- Design Patterns
- Arquitetura Hexagonal
- Clean Architecture
- Microsserviços

## 📂 Estrutura

Cada diretório representa uma POC independente, contendo seu próprio código-fonte, dependências e documentação quando necessário.

Exemplo:

```text
java-pocs/
│
├── spring-security-jwt/
├── kafka-producer-consumer/
├── redis-cache/
├── hexagonal-architecture/
├── docker-compose-example/
└── ...
```

## 🎯 Objetivos

Este repositório tem como finalidade:

- estudar novas tecnologias;
- validar arquiteturas;
- testar integrações;
- criar exemplos reutilizáveis;
- documentar soluções para problemas comuns;
- servir como material de referência para futuras implementações.

## ▶️ Executando uma POC

Cada projeto pode possuir requisitos específicos, mas normalmente basta:

```bash
git clone https://github.com/vfurinii/java-pocs.git

cd java-pocs/<nome-da-poc>

./mvnw spring-boot:run
```

ou

```bash
mvn clean install
```

Caso a POC utilize Docker:

```bash
docker compose up -d
```

## 🧪 Testes

Sempre que disponíveis:

```bash
mvn test
```

## 📚 Conteúdos explorados

Entre os assuntos abordados neste repositório estão:

- APIs REST
- Autenticação JWT
- OAuth2
- Spring Security
- Mensageria com Kafka
- Cache com Redis
- Persistência com JPA/Hibernate
- Banco de dados relacionais
- Testes unitários
- Testes de integração
- Testcontainers
- Docker
- Kubernetes
- AWS
- CI/CD
- Arquitetura Hexagonal
- Clean Architecture
- Design Patterns
- Resiliência
- Observabilidade
- Boas práticas de desenvolvimento Java

## 🤝 Contribuições

Este repositório é voltado principalmente para estudos pessoais, mas sugestões e melhorias são sempre bem-vindas através de Issues ou Pull Requests.

## 👨‍💻 Autor

**Vitor Matheus Garcia Furini**

Java Developer

- GitHub: https://github.com/vfurinii
- LinkedIn: https://www.linkedin.com/in/vitor-furini/

---

⭐ Caso este repositório seja útil para seus estudos, considere deixar uma estrela.
