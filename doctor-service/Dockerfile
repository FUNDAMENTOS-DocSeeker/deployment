FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/doctor-0.0.1-SNAPSHOT.jar doctor-service.jar
ENTRYPOINT ["java", "-jar", "doctor-service.jar"]