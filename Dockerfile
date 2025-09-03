FROM openjdk:21-jdk-slim
COPY build/libs/app.jar app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/app.jar"]
EXPOSE 8080
