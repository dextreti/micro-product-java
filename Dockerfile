# Usamos una imagen ligera de Java 21
FROM eclipse-temurin:21-jre-alpine

# Creamos el directorio para la base de datos SQLite
RUN mkdir -p /app/database && chmod 777 /app/database

WORKDIR /app

# Copiamos el JAR generado (ajusta el nombre si es diferente en tu pom.xml)
COPY infra-adapters-driving-api/target/*.jar app.jar

# Exponemos el puerto que usa tu Spring Boot
EXPOSE 8080

# Ejecutamos la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]