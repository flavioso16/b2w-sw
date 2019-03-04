FROM openjdk:8-jdk-alpine
LABEL maintainer="flavioso16@gmail.com"
COPY target/b2w-sw-0.0.1-SNAPSHOT.jar b2w-sw.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "/b2w-sw.jar"]
EXPOSE 8080