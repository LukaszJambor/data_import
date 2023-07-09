FROM openjdk:17-jdk
ADD . /test
ADD target/app-0.0.1-SNAPSHOT.jar app-app.jar
EXPOSE 9090 9091
ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,address=*:9091,server=y,suspend=n
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app-app.jar" ]