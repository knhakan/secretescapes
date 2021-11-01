FROM openjdk:latest
EXPOSE 8081
COPY target/paymentapp-0.0.1-SNAPSHOT.jar paymentapp-service.jar
ENTRYPOINT ["java","-jar","/paymentapp-service.jar"]