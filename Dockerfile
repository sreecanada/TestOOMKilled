FROM eclipse-temurin:17-jre

WORKDIR /app

COPY target/oom-test-1.0.0.jar app.jar

ENTRYPOINT ["java", "-Xms64m", "-Xmx1024m", "-jar", "app.jar"]