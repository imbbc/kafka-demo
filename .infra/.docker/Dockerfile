FROM adoptopenjdk/openjdk11:latest
RUN mkdir /number_app
COPY build/libs/*.jar /number_app/app.jar
ENTRYPOINT ["java","-jar","/numberApp/app.jar"]