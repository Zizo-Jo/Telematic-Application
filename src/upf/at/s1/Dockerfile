FROM amazoncorretto:21-alpine3.18-jdk

WORKDIR /var/java

COPY . .

# 1. Use '-d .' to force javac to create the package directories (upf/at/s1/...)
RUN javac -d . *.java

# 2. Run the class using its FULL package name
CMD ["java", "upf.at.s1.RaceConditionDemo"]