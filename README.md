# Build and Deploy

## Building the project

    mvn clean package

## Running the project

    java -jar target/spring-boot-example-1.0NAPSHOT.jar

## Debugging the project

    java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=4000,suspend=n -jar target/spring-boot-example-1.0NAPSHOT.jar
  

# Invoking the services

## Starting a scheduled task

    curl -X POST -H "Content-Type: application/json" -d '{"host":"localhost","port":80,"messageInterval":1000,"message":"blah blah"}' http://localhost:8080/start

## Stopping the running

    curl -X POST http://localhost:8080/stop

