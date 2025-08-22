FROM amazoncorretto:23
ARG JAR_FILE=target/*.jar
COPY ./target/dungeon-game-stress-poc-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080