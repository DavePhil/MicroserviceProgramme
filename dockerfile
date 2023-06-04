FROM openjdk:8
WORKDIR /app

COPY target/microprogramme.jar /app
CMD ["java","-jar","microprogramme.jar"]