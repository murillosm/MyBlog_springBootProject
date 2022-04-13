FROM openjdk:17-oracle

EXPOSE 8080:8080

WORKDIR /app

COPY target/springBootProject-0.0.1-SNAPSHOT.jar /app/springBootProject.jar

ENTRYPOINT ["java", "-jar", "springBootProject.jar"]