FROM openjdk:8-jdk-alpine
#FROM winamd64/openjdk:8
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Xms12M", "-Xmx64M", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]