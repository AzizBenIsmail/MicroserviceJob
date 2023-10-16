FROM openjdk:11
EXPOSE 8055
ADD target/Job-0.0.1-SNAPSHOT.jar MicroJobMS.jar
ENTRYPOINT ["java","-jar","MicroJobMS.jar"]
