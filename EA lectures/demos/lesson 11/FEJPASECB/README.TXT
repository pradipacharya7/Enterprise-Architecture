 THIS IS THE JSP edition of Spring Boot BUILDING A WAR file

We have to BUILD a WAR [ via STS wizard or maven]  
run as MAVEN build  clean install
    
 refresh project
 .war file will be inside target folder in project
 
For Local Tomcat server -  WAR:
Deploy it to the webapps [vs wtpwebapps [eclipse specific] folder...
TO DELETE [ from local Tomcat server] by examining server location [ right click on server] browse deployment location..
go  [back a folder] and in webapps folder - delete "project".WAR AND "project" folder

Can comment out server.context-path in application.properties to run on Cloud
 