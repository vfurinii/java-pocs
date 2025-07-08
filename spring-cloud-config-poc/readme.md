# Prova de Conceito - Spring Cloud Config com Java 17

Esta é uma Prova de Conceito (PoC) desenvolvida em Java 17 utilizando Maven e Spring Cloud Config. O objetivo principal é demonstrar a integração de uma aplicação Spring com um servidor de configuração centralizado.

## ✨ Tecnologias Utilizadas

- Java 17
- Maven
- Spring Boot
- Spring Cloud Config Client
- Spring Cloud (Hoxton/202x.x.x ou compatível)
- Git (como repositório de configuração)

## 📦 Estrutura do Projeto

poc-spring-cloud-config/
├── src/
│ └── main/
│ ├── java/
│  resources/
│ ├── application.properties
│ ├── application.yml
│ ├── application-dev.yml
│ ├── application-prod.yml
│ └── application-stage.yml
├── pom.xml
└── README.md

## 📄 Como executar o projeto
1. Certifique-se de ter o Java 17 e o Maven instalados em sua máquina.
2. Clone o repositório:
   ```bash
   git clone
3. Navegue até o diretório do projeto:
   ```bash
   cd poc-spring-cloud-config
   ```
4. Execute o comando Maven para compilar e iniciar a aplicação:
   ```bash
    mvn spring-boot:run -Dspring-boot.run.profiles=dev,prod,stage
    ```
