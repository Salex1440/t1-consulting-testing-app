FROM openjdk:21-slim
WORKDIR /app
COPY target/*-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]