FROM openjdk:17
ADD build/libs/user-service-0.0.1-SNAPSHOT.jar user.jar
ENTRYPOINT ["java", "-jar", "user.jar"]