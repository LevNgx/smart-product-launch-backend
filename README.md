# 💡 Idea Backend – Smart Product Launch Backend

This project is the **backend of the Smart Product Launch Dashboard**, designed to manage user authentication and idea submissions. It demonstrates core backend development skills including secure authentication, service architecture, and scalable deployment.

---

## 🎯 Purpose

This backend serves as the **core engine** for the Smart Product Launch Dashboard. It handles user registration, login, authentication, and allows users to submit and manage ideas for product development.

---

## 🧠 What’s Implemented

This Spring Boot project demonstrates hands-on backend architecture skills:

### ✅ Core Layers and Architecture

* **Entities**: Java classes mapped to PostgreSQL tables (e.g., `User`, `Idea`)
* **DTOs**: Used for clean data transfer between layers (e.g., `IdeaRequest`, `LoginRequest`, `JwtResponse`)
* **Repositories**: JPA-based interfaces for database operations
* **Services**: Business logic is separated via `IdeaService`, `UserService`, etc.
* **Controllers**: REST endpoints for `auth` and `ideas`
* **Exception Handling**: Centralized via custom exception classes and handlers
* **Security**: Custom JWT security configuration and filters
* **Utility**: Helper methods for JWT generation, validation, and other common tasks

### 📁 Project Structure

```
.
├── controller     # REST API endpoints
├── config         # Spring and security configuration classes
├── dto            # Data Transfer Objects
├── exception      # Custom exception classes
├── model          # JPA entities
├── repository     # JPA repositories
├── security       # JWT filters and security logic
├── service        # Business logic
├── utility        # Utility classes like JwtUtils
```

### 🔐 Security

* **Custom Security Configuration**: Defined via `SecurityFilterChain`
* **JWT Authentication**:

    * Token creation and validation via `JwtUtils`
    * Filter chain intercepts and authenticates requests with `JwtAuthenticationFilter`
    * Unauthorized handler: `JwtAuthenticationEntryPoint`
* **Custom \*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*`UserDetailsService`**: To load users from DB for authentication
* **PasswordEncoder**: Secure password hashing using `BCryptPasswordEncoder`

### 🌍 CORS Configuration

* Custom global CORS settings via a `CorsConfigurationSource` bean

### 🗄️ Database Integration

* **PostgreSQL + JPA + Hibernate**:

    * Connected using `spring.datasource.*` properties via env variables
    * Entities mapped using `@Entity`, `@Id`, `@GeneratedValue`, `@ManyToOne` etc.
    * Repositories auto-wired using Spring Data JPA

### ☁️ Deployment Architecture

* The backend is **deployed to an AWS EC2 instance** using a GitHub Actions CI/CD pipeline
* The app is containerized using Docker, and GitHub Actions builds and pushes the image to Docker Hub, then deploys it on EC2
* The database is managed by **Amazon RDS**, and the backend connects securely from EC2 to RDS over port 5432

---

## 🚀 Features

* JWT-based Authentication (`/api/auth/register`, `/api/auth/login`)
* Role-based access handling
* Submit and manage Ideas (`/api/ideas`)
* PostgreSQL integration (aws RDS)
* Dockerized for production
* GitHub Actions CI/CD to AWS EC2
* Environment-variable-based configuration

---

## 🛠 Tech Stack

| Layer      | Tech                     |
| ---------- | ------------------------ |
| Language   | Java 17                  |
| Framework  | Spring Boot 3.4.5        |
| Build Tool | Maven                    |
| Database   | PostgreSQL (via aws RDS) |
| ORM        | JPA + Hibernate          |
| Auth       | Spring Security + JWT    |
| Packaging  | Docker                   |
| Deployment | GitHub Actions → EC2     |

---

## ⚙️ Environment Variables

These should be set at runtime or in `.env` or GitHub Secrets:

```env
DATABASE_URL=jdbc:postgresql://<host>:5432/<dbname>
DATABASE_USERNAME=<your-db-user>
DATABASE_PASSWORD=<your-db-password>
```

---

## 🐳 Docker Instructions

### 🏗️ Build Docker Image

```bash
docker build -t yourdockerhub/launchpad-backend .
```

### ▶️ Run Docker Container

```bash
docker run -d \
  -p 8080:8080 \
  --name logistics-backend \
  -e DATABASE_URL=jdbc:postgresql://<rds-host>:5432/<dbname> \
  -e DATABASE_USERNAME=your_user \
  -e DATABASE_PASSWORD=your_password \
  yourdockerhub/launchpad-backend
```

---

## ☁️ GitHub Actions Deployment (to AWS EC2)

Automated deployment workflow:

* On push to main branch
* Build Docker image
* Push to Docker Hub
* SSH into EC2
* Pull and restart container

Secrets used:

| Secret Name           | Description                   |
| --------------------- | ----------------------------- |
| `DOCKERHUB_USERNAME`  | Docker Hub username           |
| `DOCKERHUB_PASSWORD`  | Docker Hub password/token     |
| `AWS_EC2_IP`          | Public IP of EC2 instance     |
| `AWS_SSH_USERNAME`    | EC2 SSH user (e.g., `ubuntu`) |
| `AWS_SSH_PRIVATE_KEY` | EC2 SSH private key           |
| `DATABASE_URL`        | JDBC URL for RDS              |
| `DATABASE_USERNAME`   | RDS username                  |
| `DATABASE_PASSWORD`   | RDS password                  |

---

## 📬 API Endpoints

### 🔐 Authentication (Public Routes)

| Endpoint             | Method | Description              |
| -------------------- | ------ | ------------------------ |
| `/api/auth/register` | POST   | Register a new user      |
| `/api/auth/login`    | POST   | Authenticate and get JWT |

### 💡 Ideas (Protected Routes)

| Endpoint                   | Method | Description                       |
| -------------------------- | ------ | --------------------------------- |
| `/api/ideas`               | POST   | Submit a new idea under the user  |
| `/api/ideas/user/{userId}` | GET    | Get all ideas submitted by a user |

> Protected endpoints require a valid JWT in the `Authorization` header.

---

## 📦 Maven Build

```bash
./mvnw clean install
```

## ▶️ Run Locally

```bash
./mvnw spring-boot:run
```

---

## 👨‍💻 Author

Name: Sai Venkat Nijagala

LinkedIn: linkedin.com/in/sai-venkat-nijagala-241427281

Email: [venkat.nijagala@gmail.com](mailto:venkat.nijagala@gmail.com)\\

This project demonstrates production-grade Spring Boot backend skills including layered architecture, JWT auth, Docker, and cloud deployment to EC2 with secure PostgreSQL integration via Amazon RDS.

---
