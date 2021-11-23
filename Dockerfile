FROM openjdk:17-jdk-alpine3.13

ARG JAR_FILE=/build/libs/*.jar
COPY ${JAR_FILE} mysqldemo-app.jar

ENTRYPOINT ["java","-jar","/mysqldemo-app.jar"]