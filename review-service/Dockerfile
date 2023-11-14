FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/Review-0.0.1-SNAPSHOT.jar review-service.jar
ENTRYPOINT ["java", "-jar", "review-service.jar"]