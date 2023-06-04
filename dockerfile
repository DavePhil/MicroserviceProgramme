FROM openjdk:17-alpine
WORKDIR /app
EXPOSE 9005
COPY target/microprogramme.jar /app
CMD ["java","-jar","microprogramme.jar"]