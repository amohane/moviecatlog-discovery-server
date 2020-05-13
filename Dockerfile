FROM openjdk:8
EXPOSE 8761
ARG JAR_FILE=/target/*.jar
ADD ${JAR_FILE} moviecatlog-discovery-server.jar
ENTRYPOINT ["java","-jar","moviecatlog-discovery-server.jar"]