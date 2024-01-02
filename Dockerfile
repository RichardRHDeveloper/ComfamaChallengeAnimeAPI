FROM openjdk:17-jdk-slim-buster
ADD ./build/libs/*.jar app.jar
ENTRYPOINT ["java","-Djava.awt.headless=true","-Duser.timezone=America/Bogota","-jar","/app.jar"]