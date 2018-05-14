#set($hash = '#')
${hash} ${artifactId}
[Georgia Clinical and Translational Science Alliance (Georgia CTSA)](http://www.georgiactsa.org), [Emory University](http://www.emory.edu), Atlanta, GA

${hash}${hash} What does it do?
Write a description here

${hash}${hash} Version 1.0 development series
Latest release: [![Latest release](https://maven-badges.herokuapp.com/maven-central/${groupId}/${artifactId}/badge.svg)](https://maven-badges.herokuapp.com/maven-central/${groupId}/${artifactId})

## Version history
No final releases yet

${hash}${hash} Build requirements
* [Oracle Java JDK 8](http://www.oracle.com/technetwork/java/javase/overview/index.html)
* [Maven 3.2.5 or greater](https://maven.apache.org)

${hash}${hash} Runtime requirements
* [Oracle Java JRE 8](http://www.oracle.com/technetwork/java/javase/overview/index.html)
* [Tomcat 7](https://tomcat.apache.org)
* Also running
  * The [${serviceArtifactId}](https://github.com/eurekaclinical/${serviceArtifactId}) war
  * The [cas-server](https://github.com/eurekaclinical/cas) war

${hash}${hash} Proxied REST APIs
You can call all of [${serviceArtifactId}](https://github.com/eurekaclinical/${serviceArtifactId})'s REST APIs through the proxy. Replace `/protected/api` with `/proxy-resource`. The point of doing this is for web clients -- you can deploy the webapp on the same server as web client, and deploy the service on a separate server.

${hash}${hash} Building it
The project uses the maven build tool. Building for the first time is typically done by invoking `mvn clean notice:generate install`. For subsequent builds, `mvn clean install` can be invoked on the command line. For simple file changes, not additions or deletions, you can usually use `mvn install`. See https://github.com/eurekaclinical/dev-wiki/wiki/Building-Eureka!-Clinical-projects for more details.

${hash}${hash} Performing system tests
You can run this project in an embedded tomcat by executing `mvn  process-resources cargo:run -Ptomcat` after you have built it. It will be accessible in your web browser at https://localhost:8443/${artifactId}/. Your username will be `superuser`.

${hash}${hash} Installation
${hash}${hash}${hash} Configuration
This webapp is configured using a properties file located at `/etc/${shortNamespace}/application.properties`. It supports the following properties:
* `${propertyNamespace}.callbackserver` = https://hostname:port
* `${propertyNamespace}.url` = https://hostname.of.service:port/${serviceArtifactId}
* `${propertyNamespace}.url` = https://hostname:port/${artifactId}
* `cas.url`=https://hostname.of.casserver:port/cas-server

A Tomcat restart is required to detect any changes to the configuration file.

${hash}${hash}${hash} WAR installation
1) Stop Tomcat.
2) Remove any old copies of the unpacked war from Tomcat's webapps directory.
3) Copy the warfile into the tomcat webapps directory, renaming it to remove the version. For example, rename `${artifactId}-${version}.war` to `${artifactId}.war`.
4) Start Tomcat.

${hash}${hash} Maven dependency
```
<dependency>
    <groupId>${groupId}</groupId>
    <artifactId>${artifactId}</artifactId>
    <version>${version}</version>
</dependency>
```

${hash}${hash} Developer documentation
* [Javadoc for latest development release](http://javadoc.io/doc/${groupId}/${artifactId}) [![Javadocs](http://javadoc.io/badge/${groupId}/${artifactId}.svg)](http://javadoc.io/doc/${groupId}/${artifactId})

${hash}${hash} Getting help
Feel free to contact us at help@eurekaclinical.org.

