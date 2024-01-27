FROM openjdk:17-alpine
EXPOSE 8080
COPY target/springboot-docker-mongodb-api.jar springboot-docker-mongodb-rest-api.jar
ENTRYPOINT ["java", "-jar", "springboot-docker-mongodb-rest-api.jar"]
