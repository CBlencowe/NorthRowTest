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

[PERSONAL NOTE]
I use Maven as Gradles causes problems. I use Gradles with Android development, however, I am yet to
have any consistent success using it with Spring.
____________________________________________________

Step two:

Using terminal cd to the project.
Run command “mvn package”.
Run command “mvn clean spring-boot:run”
____________________________________________________
Step three: 

Set up the application for RESTful use on a Tomcat server as a WAR file.
Find the main class file (denoted by @SpringBootApplication) and extend it by SpringBootServletInitializer

[PERSONAL NOTE]
I am unsure as to how you host your Spring system but we have a Tomcat server that we run WAR files on,
this seems to be the most practical for our purposes
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

[PERSONAL NOTE]
I considered using PagingAndSortingRepository instead of JPA as I have found this works better with ThymeLeaf,
however, seeing as the application spec didn’t include a front end I chose to go with the more widespread JPA.
____________________________________________________
Step five: 

Move from SQL to H2 data storage
    - Something I hadn’t done before
    - I used my domain to host a database for testing, as I knew this worked
    - H2 was alarmingly simple to use and all the configuring was in one line in the application.properties file
    - “spring.datasource.url=jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=MYSQL"

[PERSONAL NOTE]
The mysql dependency and application.properties code is included as I hadn’t used H2 before and wanted 
to make sure that it was working with out throwing too many unknowns into the mix.
____________________________________________________
Step six: 

Implement SpringSecurity (The way I did it)
    - Extend a security class with WebSecurityConfigurerAdapter
    - Add the annotations @Configuration & @EnableWebSecurity
    - Implement a basic HTTP authorization on requests
    	- Allow on the specified on the role “ADMIN"
    	- Allow on GET, POST, PUT and DELETE
    - Add a configuration on an in memory authentication on the hardcoded username and password
    	- Set the role “ADMIN”

[PERSONAL NOTE]
Implement Bearer access tokens (A way I considered doing it)
    - When I first read this I wanted to try something that I hadn’t done before
    - Storing a JWT key in a header
    - Pulling the key from the header in the security service an validating it
    - Making a key dispersal authority
    - Giving keys a nonce and making the application request a key for each session
I decided against this a it made the application exponentially more complex the necessary and it would have 
taken me far longer to learn, I will at some point teach myself how to do this as this is how most APIs are 
supposed to function.
