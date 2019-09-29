# flight-booking
Project Configuration:

Springboot 2.1
Java 1.8
JWT 0.9.1
Eclipse
MySQL database

Springboot project configurations:-

application.properties:-
Provide database connection , username and password.
First time replace "none" with "create" in below line:
spring.jpa.hibernate.ddl-auto=none

In case of any change go to project directory and run below commands to build and run project:-
Build project
	mvn clean install
Run project
	java -jar target/flight-booking-0.0.1-SNAPSHOT.jar



