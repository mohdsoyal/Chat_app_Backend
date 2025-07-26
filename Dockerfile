# Use OpenJDK as base image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy the JAR file
COPY target/Chat-App-0.0.1-SNAPSHOT.jar app.jar



# Expose port 8080
EXPOSE 8080

# Command to run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
