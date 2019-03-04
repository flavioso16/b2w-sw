FROM openjdk:8-jdk-alpine

COPY target/b2w-sw-0.0.1-SNAPSHOT.jar b2w-sw.jar
COPY wait-for-it.sh wait-for-it.sh

RUN apk add --no-cache bash

ENTRYPOINT bash wait-for-it.sh -t 0 cassandra:9042 -- java -jar -Dspring.profiles.active=$PROFILE_ENV /b2w-sw.jar

EXPOSE 8080