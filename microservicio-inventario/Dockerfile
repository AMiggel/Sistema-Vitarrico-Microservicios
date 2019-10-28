FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/microservicio-inventario-0.0.1-SNAPSHOT.jar target/app.jar
EXPOSE 9001
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=local","target/app.jar"]
