# Use the official OpenJDK image from the Docker Hub
FROM openjdk:21-jdk-slim
EXPOSE 8080
ADD target/springboot-kubs-app.jar springboot-kubs-app.jar
ENTRYPOINT ["java","-jar","/springboot-kubs-app.jar"]



