# Use an official Maven image as the base image
FROM maven:3.8.3-openjdk-17 AS build
# Set the working directory in the container
WORKDIR /app
# Copy the pom.xml and the project files to the container
COPY . .

# Build the application using Maven
RUN mvn clean package -DskipTests
# Use an official OpenJDK image as the base image
FROM openjdk:17-jdk-slim

COPY --from=build /app/target/eureka-app.jar /app/target/eureka-app.jar

ENTRYPOINT ["java", "-jar", "/app/target/eureka-app.jar"]

EXPOSE 8761
