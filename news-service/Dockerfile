FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/News-0.0.1-SNAPSHOT.jar news-service.jar
ENTRYPOINT ["java", "-jar", "news-service.jar"]