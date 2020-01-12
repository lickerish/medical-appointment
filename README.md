# Spring Boot App -> Medical Apointment

App allows making an appointment to the doctor.
Made using Kotlin and Spring Boot.

## Built With

* 	[Gradle](https://gradle.org/)
* 	[Kotlin](https://kotlinlang.org/)
* 	[Spring Boot](https://spring.io/projects/spring-boot)
* 	[H2](https://www.h2database.com/html/main.html)
* 	[Git](https://git-scm.com/)
* 	[Swagger](https://swagger.io/)

## Inobvious plugins

* 	[NoArg Compiler Plugin](https://kotlinlang.org/docs/reference/compiler-plugins.html)
```shell
  id("org.jetbrains.kotlin.plugin.noarg") version "1.3.61"
```

## External Tools Used

* [Postman](https://www.getpostman.com/)

## To-Do

- [x] CRUD
- [x] NoArg Compiler Plugin
- [x] Swagger
- [ ] Tests!
- [ ] Make it RESTful (CRUD)
- [ ] Security
- [ ] Web - HTML, JavaScript (jQuery)

## Running the application locally

Execute `main` method in the `pl.lickerish.medicalappointment.MedicalAppointmentApplication` class from your IDE.

- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing build.gradle.kts
- Open IDE and import the project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Java Application

Alternatively you can use the [Spring Boot Gradle plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins.html#build-tool-plugins-gradle-plugin) like so:

```shell
gradle bootRun
```

## Documentation

* [Swagger](http://localhost:8080/swagger-ui.html) - API Documentation

## Packages

- `models` — to hold our entities;
- `repositories` — to communicate with the database;
- `services` — to hold our business logic;
- `controllers` — to listen to the client;
- `dto` — to provide transfer purpose object;
- `config` — to provide custom configuration;
- `exceptions` — to provide custom exceptions;

- `resources/` - Contains all the static resources, templates and property files.
- `resources/application.properties` - It contains application-wide properties.

- `test/` - will contain unit and integration tests

- `build.gradle.kts` - contains all the project dependencies
 
  
## Resources

* [HTTP Status Codes](https://www.restapitutorial.com/httpstatuscodes.html)
