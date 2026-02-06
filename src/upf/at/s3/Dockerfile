FROM tomcat:9.0-jdk8
COPY src /var/www/java
WORKDIR /var/www/java
RUN javac -cp /usr/local/tomcat/lib/servlet-api.jar upf/at/s3/TestServlet.java
RUN mkdir -p /usr/local/tomcat/webapps/ROOT/WEB-INF/classes/upf/at/s3/
RUN cp upf/at/s3/TestServlet.class /usr/local/tomcat/webapps/ROOT/WEB-INF/classes/upf/at/s3/
COPY index.html /usr/local/tomcat/webapps/ROOT/
COPY web.xml /usr/local/tomcat/webapps/ROOT/WEB-INF/