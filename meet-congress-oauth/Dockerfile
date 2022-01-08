FROM openjdk:12
VOLUME /tmp
EXPOSE 9100
ADD ./target/meet-congress-oauth-0.0.1-SNAPSHOT.jar oauth-service.jar
ENTRYPOINT ["java","-jar","/oauth-service.jar"]