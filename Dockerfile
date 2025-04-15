# Step 1: Use Maven image to build the application
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy Maven project files
COPY /pom.xml .
COPY /src ./src

# Build the application (skip tests for faster build)
RUN mvn clean package -DskipTests

# Step 2: Use a lightweight JDK runtime for production
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy the built JAR file from the previous step
COPY --from=build /app/target/bralis-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 for the Spring Boot app
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]