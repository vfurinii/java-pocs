# Usar Amazon Corretto 23 (Java 23) como base
FROM amazoncorretto:23

# Definir diretório de trabalho
WORKDIR /app

# Copiar o JAR gerado pelo Maven
COPY target/spring-docker-demo-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta padrão do Spring Boot
EXPOSE 8080

# Rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
