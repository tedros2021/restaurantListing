FROM openjdk:21
WORKDIR /opt
#COPY target/*.jar /opt/app.jar

COPY ./target/restaurant-service.jar /opt/app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
#ENTRYPOINT exec java $JAVA_OPTS -jar app.jar

#DOCKER CONFIGURATION FOR JENKINS
#FROM openjdk:21
#EXPOSE 8080
#ADD target/restaurant-service.jar restaurant-service.jar
#ENTRYPOINT ["java","-jar","/restaurant-service.jar"]

#Use finalName tag instead of changing the artifact for changing the jar name
#       <finalName>restaurant-service</finalName>
#    </build>

#DOCKER CONFIGURATION FOR LOCALY IN INTELLIJ
#FROM openjdk:21
#ARG JAR_FILE=targer/*.jar
#COPY ./target/restaurant-service.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
#
