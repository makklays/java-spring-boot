FROM maven:jdk17
#FROM openjdk:17.0.2-jdk

COPY --chown=maven:maven . /app
#COPY . /app
WORKDIR /app
RUN maven build

EXPOSE 8080
WORKDIR /app

CMD java -jar ./build/libs/application-0.0.1-SNAPSHOT.jar

# docker build -t test_spring_k8s .
# docker images
# docker run -it --rm