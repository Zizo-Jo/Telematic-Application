FROM amazoncorretto:21-alpine3.18-jdk
COPY src /var/java
WORKDIR /var/java
RUN javac upf/at/s1/*.java

# CHANGE: Run the class name, not the file.
CMD ["java", "upf.at.s1.RaceConditionDemo"]