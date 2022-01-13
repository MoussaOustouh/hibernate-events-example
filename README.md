# Hibernate Events in a Spring Boot Application
This is a small and simple Spring Boot application that demonstrates how Hibernate events can be used for data change detection. The application
is a REST API that performs CRUD operations on an in-memory h2 database using Hibernate. The application consists of a couple of custom Hibernate event listeners 
that are registered with Hibernate via Spring bootstrapping. In this simple example, the event listeners print details of insert and update events to
the standard output. In order to make the event handling asynchronous, the listeners perform their actions in separate threads. 

## Running the application
You can run this application in different ways, depending on your preference and your system configuration.

- ### Use IDE
You can open the project and run it using an IDE such as IntelliJ IDEA or Eclipse IDE.

- ### Use Maven
If you have Java and Maven installed, you can run the application using the Maven Spring Boot plugin. Execute `mvn spring-boot:run`


## Running Tests to See Hibernate Events in Action
Once you have the application up and running, you can use the included Postman tests collection to run some test CRUD operations on the API and 
see the event listeners in action.
