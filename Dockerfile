FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests


FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app
COPY --from=builder /app/configuration/web-api/target/*.jar expenses_app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/expenses_app.jar"]