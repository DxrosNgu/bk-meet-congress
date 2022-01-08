FROM openjdk:12
VOLUME /tmp
ADD ./target/user-management-0.0.1-SNAPSHOT.jar user-management-service.jar
ENTRYPOINT ["java","-jar","/user-management-service.jar"]