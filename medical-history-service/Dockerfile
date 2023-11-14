FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/MedicalHistory-0.0.1-SNAPSHOT.jar medical-history-service.jar
ENTRYPOINT ["java", "-jar", "medical-history-service.jar"]