# Basic REST API Blog Site CRUD Example /w Spring Boot

Spring Boot REST API example with Spring Data

## Getting Started

### Dependencies

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.8.0</version>
		</dependency>
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.8.0</version>
		</dependency>
		<dependency>
			<groupId>org.modelmapper</groupId>
			<artifactId>modelmapper</artifactId>
			<version>2.3.0</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.plugin</groupId>
			<artifactId>spring-plugin-core</artifactId>
			<version>1.2.0.RELEASE</version>
		</dependency>

## REST Resources

![alt text](https://raw.githubusercontent.com/cnkay/blogRestApiExample/master/Images/user-controller.png)
![alt text](https://raw.githubusercontent.com/cnkay/blogRestApiExample/master/Images/postcontroller-.png)
![alt text](https://raw.githubusercontent.com/cnkay/blogRestApiExample/master/Images/comment-controller.png)
![alt text](https://raw.githubusercontent.com/cnkay/blogRestApiExample/master/Images/result.png)

## Dockerizing Application

Open terminal where location of Dockerfile directory.

`docker build -t blogapi-app`

when finished succesfully...

`docker run -p 8090:8080 blogapi-app`

* 8090 and the port inside the container - 8080, which is specified as the -p 8090:8080 argument.

## Run

`mvn spring-boot:run`

### Swagger UI

`localhost:8080/swagger-ui.html`
