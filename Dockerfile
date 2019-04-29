FROM java:8-jdk-alpine

COPY ./target/advisor-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch advisor-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","advisor-0.0.1-SNAPSHOT.jar"]