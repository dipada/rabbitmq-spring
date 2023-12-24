FROM openjdk:21-jdk
LABEL authors="dipada"
ARG JAR_FILE=target/*.jar
COPY ./target/*.jar app.jar
EXPOSE 9091
ENTRYPOINT ["java", "-jar", "/app.jar"]