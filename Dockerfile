FROM amazoncorretto:17-alpine
COPY target/Hackathon-0.0.2-SNAPSHOT.jar Hackathon-0.0.2-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Hackathon-0.0.2-SNAPSHOT.jar"]
