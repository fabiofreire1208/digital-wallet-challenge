FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/digital-wallet.jar /app/digital-wallet.jar

EXPOSE 8081

ENV JAVA_OPTS=""

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/digital-wallet.jar"]