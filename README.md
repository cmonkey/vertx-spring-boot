## vertx spring boot 

### Pre 


 git clone git@github.com:snowdrop/vertx-spring-boot.gi
 cd vertx-spring-boot 
 mvn clean install 


### build project

mvn clean install -DskipTests=true 

java -jar target/verx-spring-boot-0.0.1-SNAPSHOT.jar

curl http://localhost:8080/hello?name=foo
