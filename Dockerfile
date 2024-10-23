FROM openjdk:17-jdk-slim

ARG bobby.com

COPY target/cards-0.0.1-SNAPSHOT.jar cards-0.0.1-SNAPSHOT.jar 


ENTRYPOINT [ "java","-jar","cards-0.0.1-SNAPSHOT.jar" ]