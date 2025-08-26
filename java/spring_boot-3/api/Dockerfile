FROM openjdk:21-jdk-slim

WORKDIR /vollmed

COPY build/libs/api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD java -XX:+UseContainerSupport -Xmx512m -jar /vollmed/app.jar