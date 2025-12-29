FROM openjdk:8u141-jdk-slim

COPY gen-admin/target/gen.jar /app/gen.jar
WORKDIR /app
EXPOSE 7080

CMD ["java", "-jar","-Duser.timezone=GMT+08", "-Xms2048m", "-Xmx2048m", "gen.jar"]
