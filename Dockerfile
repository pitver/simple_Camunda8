# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy

COPY target/*.jar service.jar
CMD java $JAVA_OPTS -jar /service.jar
EXPOSE 9090


#WORKDIR /app
#
#COPY .mvn/ .mvn
#COPY mvnw pom.xml ./
#RUN ./mvnw dependency:resolve
#
#COPY src ./src
#
#CMD ["./mvnw", "spring-boot:run"]