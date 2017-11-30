FROM frolvlad/alpine-oraclejdk9:slim
VOLUME /tmp
ADD smarteng-1.0-SNAPSHO.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/urandom","-jar" "/app.jar"]