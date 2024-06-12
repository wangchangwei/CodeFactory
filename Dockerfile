FROM openjdk:8-jre-buster

COPY gen-admin/target/gen.jar /app/gen.jar
WORKDIR /app
EXPOSE 8080

CMD ["java", "-jar","-Duser.timezone=GMT+08", "-Xms2048m", "-Xmx2048m", "gen.jar"]
