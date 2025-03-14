FROM amazoncorretto:17-alpine3.15-jdk AS builder
WORKDIR /app

RUN apk --no-cache add maven=3.8.3-r0 unzip

COPY pom.xml ./

COPY . .
RUN mvn -B -e clean install -DskipTests=true

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
