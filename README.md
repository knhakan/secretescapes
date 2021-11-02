# Secret Escapes payment application  

A simple repository to implement a payment application for Secret Escapes.   
The project contains both Backend written in Java/Spring Boot and frontend written in ReactJs.  The directory *secretescapes-webapp* contains the frontend component.  
For database, one in-memory database, H2, have been used.

## Getting started
To run this app locally, you will need to :

Be able to run this repository.  
Insert your credentials of your email to send and receive emails.

### Setting up the Email Auth
Simply go to *application.properties* and insert the credentials for the email client from which you want to send email.    
    
  `spring.mail.username=*username*`  
  `spring.mail.password=*password*`  
### Modifying baseURL  

The snippet to change BaseURL is placed in *index.js* under src.   
`axios.defaults.baseURL = "http://localhost:8081/"`

### Application Installation in Docker
The application can run as a Docker container.  
  
To run the application in docker, one must install Docker first. After the installation of Docker, install jar file of the application, 
as `paymentapp-0.0.1-SNAPSHOT.jar`, (Maven can be used to install it) and place it under target folder (target folder is placed in root 
directory of the project). Precisement both in naming and in path selection is important since the Dockerfile 
contains `COPY target/paymentapp-0.0.1-SNAPSHOT.jar paymentapp-service.jar` command. If the user wants to customise naming or path, 
he/she should simply change the paths and the namings as desired in this command, as well.  

## Setting up Frontend

You must have node installed in your system. Go to directory *secretescapes-webapp* and run the code
  `npm install`  

Once the installation is completed, run
 `npm start` 
The application will be up in localhost:3000
