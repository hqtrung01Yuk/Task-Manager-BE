## Back-end Task Manager Project

<div align="center">
    <p>
        <a href="https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html">
            <img src="https://img.shields.io/badge/Java-17+-red?logo=java&logoWidth=30" alt="Java" height="20">
        </a>
        <a href="https://spring.io/projects/spring-framework">
            <img src="https://img.shields.io/badge/Spring_Framework-6.2.8-green?logo=spring&logoWidth=30" alt="Spring Framework" height="20">
        </a>
        <a href="https://spring.io/projects/spring-boot">
            <img src="https://img.shields.io/badge/Spring_Boot-3.5.3-green?logo=springboot&logoWidth=30" alt="Spring Boot" height="20">
        </a>
        <a href="https://spring.io/projects/spring-data">
            <img src="https://img.shields.io/badge/Spring_Data-2025.0.1-green?logo=spring-data.svg&logoColor=white" alt="Spring Data" height="20">
        </a>
        <a href="https://spring.io/projects/spring-security">
            <img src="https://img.shields.io/badge/Spring_Security-6.5.1-green?logo=spring-security&logoWidth=30" alt="Spring Security" height="20">
        </a>
        <a href="https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/jwt.html">
            <img src="https://img.shields.io/badge/JWT-0.12.5-orange?logo=jsonwebtokens&logoWidth=30" alt="JWT" height="20">
        </a>
        <a href="https://mariadb.org/">
            <img src="https://img.shields.io/badge/MariaDB-10.4.24-c0765a?logo=MariaDB&logoWidth=30" alt="JWT" height="20">
        </a>
        <a href="https://dotenvx.com/">
            <img src="https://img.shields.io/badge/.env-20.6.0-yellow?logo=.ENV&logoWidth=30" alt="JWT" height="20">
        </a>
    </p>
</div>

### Overview

A REST API built with Spring Boot and JWT (JSON Web Token) for authentication. This project follows a tutorial for learning purposes, focusing on implementing secure API endpoints, role-based access control, and JWT token management.

### Feature:

- **JWT-based Authentication** (Login, Registration, Token Refresh)
- **Role-based Authorization** (EMPLOYEE, ADMIN)
- **CRUD Operations** for demo entities (Task, Users)
- **RESTful Standards** (HTTP status codes, JSON responses)
- **Configure .env file** for manage variable of database URL and JWT secrect

### Installation

1. Prerequisites:

- Java Version 17+
- Gradle
- MariaDB (Can be using XAMPP/WAMP Server, MariaDB)

2. Steps:

```bash
# Clone the repository
git clone https://github.com/hqtrung01Yuk/Task-Manager-BE.git

# Navigate to the project
cd Task-Manager-BE

# Build (Gradle)
./gradlew build # if using .env can be throw exception of JPA

# Run (Gradle)
./gradlew bootRun
```

3. **Backend will be available at**: `http://localhost:8080/api/`

- **Configure .env file**:

```yaml
spring:
  # database
  datasource:
    url: ${SPRING_DATASOURCE_URL}
    username: ${SPRING_DATASOURCE_USERNAME}
    password: ${SPRING_DATASOURCE_PASSWORD}
    driver-class-name: ${SPRING_DATASOURCE_DRIVER_CLASS_NAME}

# jwt
jwt:
  secret-key: ${JWT_SECRET_KEY}
  expiration-ms: ${JWT_EXPIRATION_MS}
```

using file `.env.example`:

```bash
# .env.example

SPRING_DATASOURCE_URL=SPRING_DATASOURCE_URL
SPRING_DATASOURCE_USERNAME=SPRING_DATASOURCE_USERNAME
SPRING_DATASOURCE_PASSWORD=SPRING_DATASOURCE_PASSWORD
SPRING_DATASOURCE_DRIVER_CLASS_NAME=SPRING_DATASOURCE_DRIVER_CLASS_NAME

JWT_SECRET_KEY=JWT_SECRET_KEY
JWT_EXPIRATION_MS=JWT_EXPIRATION_MS

```

### Usage

1. **Authentication**

- **Signup**

```http
POST /api/auth/signup
Body: { "name": "test", "username": "test", "password": "123456" }
```

- Login (Get JWT)

```http
POST /api/auth/login
Body: { "username": "test", "password": "123456" }
```

2. Access Protected Routes

```http
GET /api/products
Headers: { "Authorization": "Bearer YOUR_JWT_TOKEN" }
```

### Project Structure

```tree
src/
├── main/
│   ├── java/
│   │   ├── bootstrap/     # Data Init
│   │   ├── config/        # Security, WebConfig, JWT Authen
│   │   ├── controller/    # REST endpoints
│   │   │   ├──admin       # For admin controller
│   │   │   └──auth        # For auth controller
│   │   ├── dto/           # Request/Response objects
│   │   ├── entities/      # JPA Entities
│   │   ├── repository/    # Spring Data JPA
│   │   ├── enums/         # Enum
│   │   └── service/       # Business logic
│   │       ├── admin      # Admin service
│   │       │   └──impl    # Implement interface of Admin service
│   │       ├── impl       # Implement of interface of User, Auth
│   │       └── jwt        # JWT properties, util
│   └── resources/
│       └── application.yaml
├── test/                  # Test
└──.env.example
```

### Technologies

- **Backend**: Spring Boot 3.x, Spring Security, JWT, Common lang3
- **Database**: MariaDB
- **Tools**: Gradle, Lombok, JPA, Spring Devtools
- **Testing**: JUnit 5, Mockito
- **Other**: Dotenv
