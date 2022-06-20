# we will use openjdk 8 with alpine as it is a very small linux distro
FROM openjdk:8-jre-alpine3.9

ARG rootSrc

RUN echo ${rootSrc}
# copy the packaged jar file into our docker image
COPY ${rootSrc}/target/customer-0.0.1-SNAPSHOT.jar /customer-0.0.1-SNAPSHOT.jar

# set the startup command to execute the jar
CMD ["java", "-jar", "/customer-0.0.1-SNAPSHOT.jar"]