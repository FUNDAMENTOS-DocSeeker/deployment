FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/prescription-0.0.1-SNAPSHOT.jar prescription-service.jar
ENTRYPOINT ["java", "-jar", "prescription-service.jar"]