# NorthRowTest

Step one:
Go to “https://start.spring.io/“

Information:
Project: Maven
Language: Java
Spring Boot: 2.2.2
Group: za.co.hilltop
Artifact: NorthRowTest
Dependancies: 

Generate and extract into a directory of your choosing
____________________________________________________

Step two:

Using terminal cd to the project.
Run command “mvn package”.
Run command “mvn clean spring-boot:run”
____________________________________________________
Step three: 

Set up the application for RESTful use on a Tomcat server as a WAR file.
Find the main class file (denoted by @SpringBootApplication) and extend it by SpringBootServletInitializer
____________________________________________________
Step four: 

Add the files that will contain the entity, repository and controller (or group them together)
Add the classes for the entity, repository and controller
entity
    - Add the variables that this entity will store (id, name, type, quantity and createddate)
    - Create the getters and setters
    - Don't forget the @Entity anotation
repository
    - Implement as interface
    - Extend as JPA or PASR
    - Add any custom queries not included in JPA
controller 
    - Don't forget the @Controller anotation
    - Don't forget the @RestController anotation
    - Set the request mapping to class name (optional)
    - Add the relevent CRUD and SEARCH methods
____________________________________________________
Step five: 

Move from SQL to H2 data storage
    - Something I hadn’t done before
    - I used my domain to host a database for testing, as I knew this worked
    - H2 was alarmingly simple to use and all the configuring was in one line in the application.properties file
    - “spring.datasource.url=jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=MYSQL"

____________________________________________________
Step six: 

Implement API key on SpringSecurity
