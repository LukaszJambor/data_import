FROM openjdk:8-jdk-alpine
ADD . /test
ADD target/app-0.0.1-SNAPSHOT.jar app-app.jar
ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,address=9091,server=y,suspend=n
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app-app.jar" ]