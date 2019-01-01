# SpringBootStarter
Starter Spring Boot and repo
Basic Springboot  Rest Interface & persistence
run with  mvn spring-boot:run
point browser at http://localhost:8080


test by curl -H "Content-Type: application/json" -X POST -d '{"incomeTypeId":2,"incomeDescription":"This is a test line","fromDate":"2015-05-02T00:00:00","toDate":null,"amount":860}' http://localhost:8080/Income/add


To query DB directly:
$ sudo mysql --password
use db_example