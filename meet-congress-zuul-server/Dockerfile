FROM openjdk:12
VOLUME /tmp
EXPOSE 8190
ADD ./target/meet-congress-zuul-server-0.0.1-SNAPSHOT.jar server-zuul-service.jar
ENTRYPOINT ["java","-jar","/server-zuul-service.jar"]