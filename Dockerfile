
FROM openjdk:11-jre-slim
ADD target/spring-redit-clone-0.0.1-SNAPSHOT.jar  app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]