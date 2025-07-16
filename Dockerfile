# Use OpenJDK base image
FROM openjdk:17-jdk-alpine

# Copy the jar file
COPY target/CountryApp.jar app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app.jar"]
