FROM --platform=linux/amd64 openjdk:17-jdk-alpine
WORKDIR /app
COPY target/Student_API-0.0.1-SNAPSHOT.jar student-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "student-api.jar"]
