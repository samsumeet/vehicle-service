# Getting Started

### Guide

* To run this project you need to install Java 8 and Maven. You can find it here (https://maven.apache.org/download.cgi)

* After installing maven you can run this project manually as defined below:
	
	> cd vehicle-service
	
	> mvn clean install
	> java -jar target/vehicle-location-service-0.0.1-SNAPSHOT.jar
	
	OR
	
	> mvn spring-boot:run	

* or you can run it with start.sh (Shell Script) with following command:

		    > cd vehicle-service
			> ./start.sh

	Note : This will create docker container and our application in that with port 8080.
	URL would be http://localhost:8080


* If want to use DOCKER to run , you can try below commands
    
    > mvn clean install		
	> docker build -t door2door/vehicle-service .
	> docker run -p 8080:8080 door2door/vehicle-service
	
	Not: Please install and run docker before running these command

* Now after running the application you can view the api documentation also here(http://localhost:8080/swagger-ui.html).	
   I have used Swagger UI so that we can also test our API using Web GUI.
					
### Technology And Framework Used

* I have used Java 11 and SpringBoot Framework  for building Restfull API.
* This framework is very robust and scalable as well it's up to date with the latest technologies.
* I have following external libraries:
    -> h2(in memory database)
    -> lombok (make it easy to read)
    -> swagger (api documentation)

### Test Cases
I have added some test cases for example, we can follow these test and write different type of test cases.


