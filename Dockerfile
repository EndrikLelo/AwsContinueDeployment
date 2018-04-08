FROM openjdk:8-jre-alpine
COPY ./target/AwsCDeploymentTest-1.0.jar /usr/src/test/
WORKDIR /usr/src/test
EXPOSE 8080
CMD ["java", "-jar", "AwsCDeploymentTest-1.0.jar"]