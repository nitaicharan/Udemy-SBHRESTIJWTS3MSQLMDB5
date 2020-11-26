FROM maven:3-openjdk-11-slim AS build

WORKDIR /tmp/udemy_sbhrestijwts3msqlmdb5/

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:15-jdk-alpine

EXPOSE 8080

WORKDIR /opt/udemy_sbhrestijwts3msqlmdb5/

COPY --from=build /tmp/udemy_sbhrestijwts3msqlmdb5/target/udemy_sbhrestijwts3msqlmdb5-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "/opt/udemy_sbhrestijwts3msqlmdb5/cursomc-0.0.1-SNAPSHOT.jar"]
