# syntax=docker/dockerfile:1

# docker build --tag java-docker-test .
# docker run -p 8081:8081/tcp java-docker-test:latest

FROM openjdk:11-jdk-slim
WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]