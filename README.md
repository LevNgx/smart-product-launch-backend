📦 smart Product launch dashboard Management Backend

A backend service for managing product ideas using Spring Boot and PostgreSQL. This service exposes RESTful APIs to register users, authenticate them, and manage product ideas like submissions and retrievals.

🚀 Tech Stack

Java 17

Spring Boot (Web, JPA)

PostgreSQL

Maven (build tool)

Spring Security (Basic Auth & JWT planned)

REST APIs

Lombok (boilerplate reduction)

📁 Folder Structure

├── src/
│   ├── main/
│   │   ├── java/com/example/ideaapp
│   │   │   ├── controller/        # REST Controllers
│   │   │   ├── service/           # Business logic
│   │   │   ├── repository/        # JPA Repositories
│   │   │   ├── model/             # Entity classes
│   │   │   ├── dto/               # Data Transfer Objects (DTOs)
│   │   │   └── config/            # Security Configuration
│   │   └── resources/
│   │       └── application.properties
├── pom.xml

⚙️ Features

✅ User Registration and Login APIs

✅ Submit Ideas, Get All Ideas

✅ Filter Ideas by User or Status

✅ Secure endpoints with Spring Security

✅ PostgreSQL integration with Spring Data JPA

✅ Exception handling with @RestControllerAdvice

✅ DTOs with validation annotations

🔧 Running the Project

Ensure PostgreSQL is running locally or via RDS

Set DB credentials in application.properties

Run the app via IntelliJ or with mvn spring-boot:run

🔜 Upcoming Improvements

JWT Authentication

Dockerization + CI/CD with GitHub Actions

Swagger/OpenAPI documentation

Pagination + Sorting APIs

🤝 Author

Sai Venkat NijagalaLinkedInvenkat.nijagala@gmail.com

