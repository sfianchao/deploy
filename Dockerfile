# the first stage of image build will use a maven 3.8.2-jdk-11 parent image
FROM maven:3.8.4-jdk-8 AS MAVEN_BUILD
 
# copy the pom and src code to the container
COPY ./ ./
 
# package java application code
RUN mvn clean install

# the second stage of image build will use open jdk 11
FROM openjdk:8

# copy the packaged jar file into docker image
COPY --from=MAVEN_BUILD ./target/deploy-0.0.1-SNAPSHOT.jar ./deploy-0.0.1.jar

# assign timezone
ENV TZ=Asia/Taipei

# set the startup command to execute the jar
CMD ["java", "-jar", "./deploy-0.0.1.jar"]