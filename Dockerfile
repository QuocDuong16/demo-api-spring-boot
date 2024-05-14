#
# Build stage
#
FROM maven:4.0.0-openjdk-17 AS build
COPY . .
RUN mvn clean install

#
# Package stage
#
FROM openjdk:17-jdk
COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]
