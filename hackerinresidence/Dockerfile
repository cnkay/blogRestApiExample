FROM java:8-jdk-alpine

COPY ./target/hackerinresidence-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch hackerinresidence-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","hackerinresidence-0.0.1-SNAPSHOT.jar"] 
