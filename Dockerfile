FROM tomcat:9.0.84-jdk8-corretto
COPY src /var/www/java
WORKDIR /var/www/java
RUN javac -cp /usr/local/tomcat/lib/servlet-api.jar *.java
RUN mkdir -p /usr/local/tomcat/webapps/ROOT/WEB-INF/classes/
RUN cp -r *.class /usr/local/tomcat/webapps/ROOT/WEB-INF/classes/
COPY *.html /usr/local/tomcat/webapps/ROOT/
COPY web.xml /usr/local/tomcat/webapps/ROOT/WEB-INF