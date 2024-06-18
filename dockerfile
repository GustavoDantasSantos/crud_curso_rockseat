FROM ubuntu:latest as build

RUN apt-get update
RUN apt-get snap search openjdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:22-jdk-slim
EXPOSE 8080

COPY --from=build /target/crud_rockeseat_desafio01-0.0.1.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]