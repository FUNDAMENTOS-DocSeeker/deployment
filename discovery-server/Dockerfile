FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/discovery-server-0.0.1-SNAPSHOT.jar discovery-server.jar
ENTRYPOINT ["java", "-jar", "discovery-server.jar"]