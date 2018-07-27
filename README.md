# Eureka! Clinical Webapp Archetype
[Georgia Clinical and Translational Science Alliance (Georgia CTSA)](http://www.georgiactsa.org), [Emory University](http://www.emory.edu), Atlanta, GA

## What does it do?
This project is a maven archetype that helps you create a base eurekaclinical 
webapp project that you can build on. A working webapp project created based on 
this archetype takes care of Jersey/Guice configurations and inherits basic 
APIs from the `eurekaclinical-common` project that every eurekaclinical webapp 
project will need to have. A sample.jsp and a corresponding 
ViewSampleServlet.java are included for demonstrating the workflow and Jersey 
client/server communication, and for testing purposes. 

## Version 2.0 development series
Latest release: [![Latest release](https://maven-badges.herokuapp.com/maven-central/org.eurekaclinical/eurekaclinical-webapp-archetype/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.eurekaclinical/eurekaclinical-webapp-archetype)

This version will support creating Eureka! Clinical API gateways using the next major version release of the Eureka! Clinical service framework.

### Version 1.0
Initial release.

## Requirements
* [Oracle Java JDK 8](http://www.oracle.com/technetwork/java/javase/overview/index.html)
* [Maven 3.2.5 or greater](https://maven.apache.org)

## How to use it
You can create a new webapp project as follows:

1) Run the following command with your own values for the properties from 
`archetypeVersion` on down in the example below.
```
mvn archetype:generate -DarchetypeGroupId=org.eurekaclinical \
    -DarchetypeArtifactId=eurekaclinical-webapp-archetype \
    -DarchetypeVersion=version \
    -DgroupId=org.eurekaclinical \
    -DartifactId=eurekaclinical-microservicename-webapp \
    -Dpackage=org.eurekaclinical.packagename \
    -DpropertyNamespace=eurekaclinical.microservicename \
    -DshortNamespace=ec-microservicename \
    -DinceptionYear=four-digit-year \
    -Dversion=1.0-SNAPSHOT \
    -DserviceArtifactId=eurekaclinical-microservicename-service \
    -DserviceVersion=serviceversion \
    -DdataSource=EurekaClinicalMicroserviceNameService \
    -DclientArtifactId=eurekaclinical-microservicename-client \
    -DclientVersion=clientversion
```
Alternatively, run the following and answer the prompts:
```
mvn archetype:generate -DarchetypeGroupId=org.eurekaclinical \
    -DarchetypeArtifactId=eurekaclinical-webapp-archetype \
    -DarchetypeVersion=version
```
The `groupId`, `artifactId`, `version`, and `package` properties are standard 
maven properties that specify the groupId, artifactId and version of the 
resulting maven project, and the package that all of the project's classes will 
go in. This archetype will append `.webapp` onto the package name that you 
specify. The initial version should be `1.0-SNAPSHOT`. The other properties are 
specific to Eureka! Clinical:
* `propertyNamespace`: the first part of all of this service's property names 
in this service's `application.properties` file. This archetype will append
`.webapp` onto the value that you specify. We namespace the property names 
anticipating a future where the properties will go into a central registry.
* `shortNamespace`: currently used as the name of the directory for the 
service's application.properties file, and as the name of the service's 
logfile. For Eureka! Clinical core projects, we use the `ec` prefix instead of
`eurekaclinical` for brevity. This property is deprecated.
* `inceptionYear`: the four-digit year in which the webapp's initial release is 
anticipated. The value that you specify here goes into the `inceptionYear` tag 
in the resulting maven project's pom.xml, and it also goes into the
`etc/NOTICE.template` file.
* `serviceArtifactId`: the artifactId of the corresponding service project. 
Assumes that the service project and this project have the same groupId.
* `serviceVersion`: the version of the corresponding service project. Assumes 
that the service project and this project have the same groupId.
* `dataSource`: the value of the `dataSource` property that was used to create 
the corresponding service project.
* `clientArtifactId`: the artifactId of the corresponding client project. 
Assumes that the client project and this project have the same groupId.
* `clientVersion`: the version of the corresponding client project. Assumes 
that the client project and this project have the same groupId.

All Eureka! Clinical core projects should follow the naming convention in the 
first example above, replacing `microservicename` or `MicroserviceName` with a
name for your new service with corresponding capitalization. Projects that are 
deployment-specific should have their own groupId, and the artifactId should 
begin with an identifier for your deployment, e.g., `emory` instead of 
`eurekaclinical` for services that are specific to a deployment at Emory 
University. 

2) After confirming that you want to go ahead and create the new webapp 
project, maven will create a folder with the new project in the current 
directory, which in this example would be 
`eurekaclinical-microservicename-webapp`. It also will create a starter set of
class files and resources. Type `cd eurekaclinical-microservicename-webapp`.
3) To generate an initial NOTICE file, type `mvn notice:generate`. You will 
need to rerun this command whenever the project's dependencies change.

The resulting service project will be buildable using `mvn clean install` and 
runnable using `mvn tomcat7:run -Ptomcat`. After running, go to your web 
browser and navigate to `https://localhost:8443/eurekaclinical-microservicename-webapp/proxy-resource/test`. 
You should see `Hello World`.
