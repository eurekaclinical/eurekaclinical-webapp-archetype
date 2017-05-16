# Eureka! Clinical Webapp Archetype
[Atlanta Clinical and Translational Science Institute (ACTSI)](http://www.actsi.org), [Emory University](http://www.emory.edu), Atlanta, GA

## What does it do?
This project is an maven archetype that helps you create a base eurekaclinical webapp project that you can build on.
A working webapp project created based on this archetype takes care of Jersey/Guice configurations and inherits basic API's from eurekaclinical common that every eurekaclinical webapp project will need to have. A sample.jsp and a corresponding ViewSampleServlet.java are included for demonstrating the workflow and Jersey client/server communication, and for testing purposes. 

## Version 1.0 development series
Latest release: [![Latest release](https://maven-badges.herokuapp.com/maven-central/org.eurekaclinical/eurekaclinical-webapp-archetype/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.eurekaclinical/eurekaclinical-webapp-archetype)

## Version history
No final releases yet

## Requirements
* [Oracle Java JDK 8](http://www.oracle.com/technetwork/java/javase/overview/index.html)
* [Maven 3.2.5 or greater](https://maven.apache.org)

## How to use it
The project can be created as follows:

1) Run the following command, after changing the -DartifactId name to the name of your new project and the -DarchetypeVersion to the version of the archetype that you want to use.
```
mvn archetype:generate -DarchetypeGroupId=org.eurekaclinical -DarchetypeArtifactId=eurekaclinical-webapp-archetype -DarchetypeVersion=version -DgroupId=org.eurekaclinical -DartifactId=eurekaclinical-projectname-webapp
```
2) When prompted, specify an initial version of your new project, such as 1.0-SNAPSHOT.
3) Confirm the package name when prompted.
4) A folder with the new project should be created in the current directory, which in this example would be eurekaclinical-microservicename-service. Type `cd eurekaclinical-projectname-webapp`.
5) To generate an initial NOTICE file, type `mvn notice:generate`. You will need to rerun this command whenever the project's dependencies change.
6) Change the module-name property in the pom.xml to the name of the module you are trying to implement. Keep this consistent with the corresponding service project if you want them both to use the same application.properties. Also the service URL's and webapp URL's for the module are looked up based on this property in WebappProperties class.

This project can be tested before you build on it using embedded tomcat. change the application.properties values accordingly. Also update
service-artifact-id & service-artifact-version property in the pom.xml. open https://localhost:8443/project-name/protected/view
link on your browser to test.






