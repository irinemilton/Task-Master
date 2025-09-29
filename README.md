TaskMaster: A Full-Stack To-Do Application
TaskMaster is a modern, full-stack web application built with Java and the Spring Boot framework. It provides a secure, multi-user environment for managing personal to-do lists, featuring a clean user interface and a powerful backend.

Features
User Authentication: Secure user registration and login system powered by Spring Security.

Role-Based Access Control:

User Role: Can create, view, update, and delete their own tasks.

Admin Role: Can be created using a secret key during registration. (Admin dashboard functionality can be added in the future).

Full CRUD Functionality: Users can Create, Read, Update (mark as complete/incomplete), and Delete their to-do items.

RESTful API: A well-structured backend API for managing tasks and users.

API Documentation: Integrated Swagger UI for interactive API documentation and testing.

Modern Frontend: A responsive and stylish user interface built with Thymeleaf and custom CSS, featuring a futuristic and elegant design.

Database Integration: Uses Spring Data JPA and Hibernate to interact with a MySQL database.

Tech Stack
Backend:

Java 17

Spring Boot 3

Spring Security 6

Spring Data JPA / Hibernate

Maven

Frontend:

Thymeleaf

HTML5

CSS3 (with a modern, responsive design)

Database:

MySQL

API Documentation:

SpringDoc (Swagger UI)

Getting Started
Follow these instructions to get a local copy up and running for development and testing purposes.

Prerequisites
JDK 17 or later

Apache Maven

MySQL Server

Setup and Installation
Clone the repository:

git clone [https://github.com/your-username/TaskMaster.git](https://github.com/irinemilton/TaskMaster.git)
cd TaskMaster

Configure the database:

Open MySQL and create a new database named taskmaster_db.

Open the src/main/resources/application.properties file.

Update the spring.datasource.password property with your MySQL root password.

You can also change the admin.secret.key to a custom secret of your choice.

spring.datasource.url=jdbc:mysql://localhost:3306/taskmaster_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=your_mysql_password
admin.secret.key=TASKMASTER_SECRET_KEY_123

Build and run the application:

Open a terminal in the project's root directory.

Run the application using the Maven wrapper:

./mvnw spring-boot:run

The application will be running at http://localhost:8080.

Usage
Register an Admin User:

Navigate to http://localhost:8080/register.

Fill in your desired admin credentials.

Select "Admin" from the "Register as" dropdown.

An "Admin Secret Key" field will appear. Enter the key you defined in application.properties (the default is TASKMASTER_SECRET_KEY_123).

Click "Register".

Register a Normal User:

Go to the registration page.

Fill in your credentials and leave the role as "User".

Click "Register".

Using the Application:

Log in with your registered credentials at http://localhost:8080/login.

You will be redirected to your personal To-Do list at http://localhost:8080/todos.

From here you can add, complete, and delete your tasks.

Accessing the API Documentation:

With the application running, navigate to:

http://localhost:8080/swagger-ui.html

This will open the interactive Swagger UI where you can view and test all the backend API endpoints.

Project Structure
The project follows the standard Maven directory layout and is organized into a three-tier architecture:

com.taskmaster.config: Spring Security and Swagger (OpenAPI) configurations.

com.taskmaster.controller: Handles incoming web requests and API endpoints.

com.taskmaster.dto: Data Transfer Objects for handling form data.

com.taskmaster.entity: JPA entities that map to database tables.

com.taskmaster.repository: Spring Data JPA repositories for database interaction.

com.taskmaster.service: Contains the core business logic of the application.
