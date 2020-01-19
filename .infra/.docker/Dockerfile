FROM adoptopenjdk/openjdk11:latest
WORKDIR  /var/number_app
COPY build/libs/*.jar ./app.jar
ENTRYPOINT ["java","-jar","app.jar"]