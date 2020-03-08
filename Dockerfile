FROM registry.cn-hangzhou.aliyuncs.com/jialong-hub/jialong-common/openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/msi-github-adapter-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=dev","-jar","/app.jar"]