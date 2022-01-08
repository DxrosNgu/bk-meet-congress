FROM openjdk:12
VOLUME /tmp
EXPOSE 8761
ADD ./target/meet-congress-eureka-server-0.0.1-SNAPSHOT.jar server-eureka-service.jar
ENTRYPOINT ["java","-jar","/server-eureka-service.jar"]