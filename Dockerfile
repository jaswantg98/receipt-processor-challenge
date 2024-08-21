FROM maven:3.8-openjdk-17 AS build
LABEL authors="jaswant"

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package

FROM openjdk:17

WORKDIR /app

COPY --from=build /app/target/Receipt-Processor-Application-1.0-SNAPSHOT.jar /app/Receipt-Processor-Application.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/Receipt-Processor-Application.jar"]
