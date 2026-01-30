FROM eclipse-temurin:21-jre-alpine
RUN mkdir -p /app/database && chmod 777 /app/database
WORKDIR /app
# Apuntar al módulo de Kafka
COPY infra-adapters-driving-kafka/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]