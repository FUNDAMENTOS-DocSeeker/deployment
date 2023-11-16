FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/Appointment-0.0.1-SNAPSHOT.jar appointment-service.jar
ENTRYPOINT ["java", "-jar", "appointment-service.jar"]