FROM amazoncorretto:21-alpine3.18-jdk
COPY src /var/java
WORKDIR /var/java
RUN javac *.java

# CHANGE: Run the class name, not the file.
CMD ["java", "RaceConditionDemo"]