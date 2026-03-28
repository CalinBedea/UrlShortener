FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY . .

RUN chmod +x ./gradlew

RUN ./gradlew clean build -x test

EXPOSE 8080

CMD ["sh", "-c", "java -jar build/libs/urlshortener-0.0.1-SNAPSHOT.jar"]