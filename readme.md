## Back-end Task Manager Project

<div align="center">
    <p>
        <a href="https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html">
           <img src="https://img.shields.io/badge/Java-17+-%23ED8B00.svg?logo=data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIxMjAiIGhlaWdodD0iNjAiPjxwYXRoIGQ9Ik0xNy45NTYgNDIuNTYycy0xLjc2NyAxLjA3NSAxLjIzIDEuMzgzYzMuNi40NiA1LjUzLjM4NCA5LjUyNC0uMzg0IDAgMCAxLjA3NS42OSAyLjUzNSAxLjIzLTguOTg3IDMuODQtMjAuMzU0LS4yMy0xMy4yODgtMi4yMjd6bS0xLjE1Mi00Ljk5MnMtMS45MiAxLjQ2IDEuMDc1IDEuNzY3YzMuOTE3LjM4NCA3IC40NiAxMi4yOS0uNjE0IDAgMCAuNjkuNzY4IDEuODQzIDEuMTUyLTEwLjgzIDMuMjI2LTIyLjk2Ni4zMDctMTUuMjA4LTIuMzA0em0yMS4yIDguNzU2czEuMzA2IDEuMDc1LTEuNDYgMS45MmMtNS4xNDYgMS41MzYtMjEuNTgzIDEuOTk3LTI2LjE5MiAwLTEuNjEzLS42OSAxLjQ2LTEuNyAyLjQ1OC0xLjg0MyAxLS4yMyAxLjUzNi0uMjMgMS41MzYtLjIzLTEuNzY2LTEuMjMtMTEuNzUyIDIuNTM1LTUuMDcgMy42IDE4LjM1NyAyLjk5NSAzMy40ODgtMS4zMDYgMjguNzI2LTMuNDU2ek0xOC44IDMyLjM0N3MtOC4zNzIgMS45OTctMi45OTYgMi42ODhjMi4zMDQuMzA3IDYuODM2LjIzIDExLjA2LS4wNzcgMy40NTYtLjMwNyA2LjkxMy0uOTIyIDYuOTEzLS45MjJzLTEuMjMuNTM4LTIuMDc0IDEuMDc1Yy04LjUyNiAyLjIyNy0yNC44ODYgMS4yMy0yMC4yLTEuMDc1IDMuOTk0LTEuOTIgNy4yOTctMS43IDcuMjk3LTEuN3ptMTQuOTc4IDguMzcyYzguNjAyLTQuNDU1IDQuNjA4LTguNzU2IDEuODQzLTguMjE4LS42OS4xNTQtMSAuMzA3LTEgLjMwN3MuMjMtLjQ2Ljc2OC0uNjE0YzUuNDUzLTEuOTIgOS43NTUgNS43Ni0xLjc2NyA4Ljc1NiAwIDAgLjA3Ny0uMDc3LjE1NC0uMjN6TTE5LjY0NiA1Mi44NTRjOC4yOTUuNTM4IDIwLjk3LS4zMDcgMjEuMjc2LTQuMjI0IDAgMC0uNjE0IDEuNTM2LTYuODM2IDIuNjg4LTcuMDY2IDEuMzA2LTE1LjgyMiAxLjE1Mi0yMC45Ny4zMDcgMCAwIDEuMDc1LjkyMiA2LjUzIDEuMjN6IiBmaWxsPSIjNGU3ODk2Ii8+PHBhdGggZD0iTTI4LjU1NSA3czQuNzYyIDQuODQtNC41MzIgMTIuMTM2Yy03LjQ1IDUuOTE0LTEuNyA5LjI5NCAwIDEzLjEzNC00LjM3OC0zLjkxNy03LjUyNy03LjM3My01LjM3Ny0xMC42IDMuMTUtNC43NjIgMTEuODI4LTcuMDY2IDkuOTA4LTE0LjY3em0tMi40NTggMjIuMDQ0YzIuMjI3IDIuNTM1LS42MTUgNC44NC0uNjE1IDQuODRzNS42ODQtMi45MiAzLjA3Mi02LjUzYy0yLjM4LTMuNDU2LTQuMjI0LTUuMTQ2IDUuNzYtMTAuOTA3IDAgMC0xNS43NDYgMy45MTctOC4yMTggMTIuNTk2eiIgZmlsbD0iI2Y1ODIxOSIvPjxwYXRoIGQ9Ik03NS4zMTggMzguMTYyVjI2LjQ4NWMwLTIuOTgtMS42NjgtNS4wMDQtNS44MzgtNS4wMDQtMi4zODMgMC00LjQxLjU5Ni02LjE5NiAxLjMxbC41OTYgMi4xNDVjMS4zMS0uNDc3IDIuOTgtLjk1MyA0Ljc2Ni0uOTUzIDIuMjY0IDAgMy4zMzYuOTUzIDMuMzM2IDIuODZ2MS41NUg3MC44Yy01LjcyIDAtOC4zNCAyLjE0NS04LjM0IDUuNiAwIDIuODYgMS43ODcgNC41MjggNS4wMDQgNC41MjggMi4wMjYgMCAzLjU3NS0uOTUzIDUuMDA0LTIuMTQ1bC4yMzggMS43ODdoMi42MnpNNzEuOTggMzQuMzVjLTEuMTkgMS4wNzItMi41MDIgMS42NjgtMy42OTQgMS42NjgtMS41NSAwLTIuNTAyLS45NTMtMi41MDItMi42MnMuOTUzLTIuODYgNC43NjYtMi44NmgxLjQzdjMuODEzem0xNC41MzYgMy44MTNoLTQuMTdMNzcuMzQzIDIxLjg0aDMuNTc1bDMuMDk4IDEwLjAxLjcxNSAyLjk4YzEuNTUtNC4yOSAyLjc0LTguNjk4IDMuMjE3LTEyLjk4N2gzLjU3NGMtLjk1MyA1LjM2Mi0yLjYyIDExLjItNS4wMDQgMTYuMzIzem0xOS4zMDIgMFYyNi40ODVjMC0yLjk4LTEuNjY4LTUuMDA0LTUuODQtNS4wMDQtMi4zODMgMC00LjQwOC41OTYtNi4xOTYgMS4zMWwuNDc3IDIuMTQ1YzEuNDMtLjQ3NyAzLjA5OC0uOTUzIDQuODg1LS45NTMgMi4yNjQgMCAzLjMzNi45NTMgMy4zMzYgMi44NnYxLjU1aC0xLjE5Yy01LjcyIDAtOC4zNCAyLjE0NS04LjM0IDUuNiAwIDIuODYgMS42NjggNC41MjggNC44ODUgNC41MjggMi4xNDUgMCAzLjY5NC0uOTUzIDUuMTIzLTIuMTQ1bC4yMzggMS43ODdoMi42MnptLTMuMzM2LTMuODEzYy0xLjE5IDEuMDcyLTIuNTAyIDEuNjY4LTMuNjk0IDEuNjY4LTEuNTUgMC0yLjUwMi0uOTUzLTIuNTAyLTIuNjJzLjk1My0yLjg2IDQuNzY2LTIuODZoMS40M3YzLjgxM3ptLTQzLjcyOCA2LjU1M2MtLjk1MyAxLjQzLTIuMzgzIDIuNTAyLTQuMTcgMy4wOThsLTEuNTUtMS45MDZjMS4xOTItLjcxNSAyLjM4My0xLjc4NyAyLjg2LTIuNzQuNDc3LS44MzQuNTk2LTIuMDI2LjU5Ni00Ljc2NlYxNmgzLjU3NXYxOC4zNWMwIDMuNjk0LS4zNTggNS4xMjMtMS4zMSA2LjU1M3oiIGZpbGw9IiM0ZTc4OTYiLz48L3N2Zz4=&logoColor=white&logoSize=90" alt="Java" height="20">
        </a>
        <a href="https://spring.io/projects/spring-framework">
            <img src="https://img.shields.io/badge/Spring_Framework-6.2.8-green?logo=spring&logoWidth=30" alt="Spring Framework" height="20">
        </a>
        <a href="https://spring.io/projects/spring-boot">
            <img src="https://img.shields.io/badge/Spring_Boot-3.5.3-green?logo=springboot&logoWidth=30" alt="Spring Boot" height="20">
        </a>
        <a href="https://spring.io/projects/spring-data">
             <img src="https://img.shields.io/badge/Spring_Data-2025.0.1-green.svg?logo=data:image/svg+xml;base64,PHN2ZyBpZD0iTGF5ZXJfMSIgZGF0YS1uYW1lPSJMYXllciAxIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAxMTYuODggMTQ1Ljk3Ij48ZGVmcz48c3R5bGU+LmNscy0xe2ZpbGw6IzZkYjMzZjt9PC9zdHlsZT48L2RlZnM+PHRpdGxlPmxvZ28tZGF0YTwvdGl0bGU+PHBhdGggY2xhc3M9ImNscy0xIiBkPSJNNTguMzMsMTAxLjc5QzI5LjU0LDEwMS43OSwxNyw5OS40MiwwLDk1LjQ2djQ0bC44LjJjMTYuNCw0LDI4LjgsNi4zMiw1Ny41Myw2LjMyczQxLjM1LTIuMzgsNTcuNzQtNi4zN2wuODEtLjJ2LTQ0Qzk5LjkzLDk5LjQsODcuMjcsMTAxLjc5LDU4LjMzLDEwMS43OVoiLz48cGF0aCBjbGFzcz0iY2xzLTEiIGQ9Ik01OC4zMywwQzI5LjYsMCwxNy4yLDIuMzYuOCw2LjMybC0uOC4yVjUzYzE3LTQsMjkuNTQtNi4zMyw1OC4zMy02LjMzczQxLjYsMi4zOSw1OC41NSw2LjM5VjYuNTdsLS44MS0uMkM5OS42OCwyLjM4LDg3LjIxLDAsNTguMzMsMFoiLz48cGF0aCBjbGFzcz0iY2xzLTEiIGQ9Ik0xMTYuODgsNTUuNThsLS44MS0uMkM5OS42OCw1MS4zOSw4Ny4yMSw0OSw1OC4zMyw0OVMxNy4yLDUxLjM3LjgsNTUuMzJsLS44LjJWOTIuOTRsLjguMTljMTYuNCw0LDI4LjgsNi4zMyw1Ny41Myw2LjMzczQxLjM1LTIuMzksNTcuNzQtNi4zOGwuODEtLjJaIi8+PC9zdmc+&logoWidth=30" alt="Spring Data JPA" height="20">
        </a>
        <a href="https://spring.io/projects/spring-data-jpa">
             <img src="https://img.shields.io/badge/Spring_Data_JPA-3.2.5-green.svg?logo=data:image/svg+xml;base64,PHN2ZyBpZD0iTGF5ZXJfMSIgZGF0YS1uYW1lPSJMYXllciAxIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAxMTYuODggMTQ1Ljk3Ij48ZGVmcz48c3R5bGU+LmNscy0xe2ZpbGw6IzZkYjMzZjt9PC9zdHlsZT48L2RlZnM+PHRpdGxlPmxvZ28tZGF0YTwvdGl0bGU+PHBhdGggY2xhc3M9ImNscy0xIiBkPSJNNTguMzMsMTAxLjc5QzI5LjU0LDEwMS43OSwxNyw5OS40MiwwLDk1LjQ2djQ0bC44LjJjMTYuNCw0LDI4LjgsNi4zMiw1Ny41Myw2LjMyczQxLjM1LTIuMzgsNTcuNzQtNi4zN2wuODEtLjJ2LTQ0Qzk5LjkzLDk5LjQsODcuMjcsMTAxLjc5LDU4LjMzLDEwMS43OVoiLz48cGF0aCBjbGFzcz0iY2xzLTEiIGQ9Ik01OC4zMywwQzI5LjYsMCwxNy4yLDIuMzYuOCw2LjMybC0uOC4yVjUzYzE3LTQsMjkuNTQtNi4zMyw1OC4zMy02LjMzczQxLjYsMi4zOSw1OC41NSw2LjM5VjYuNTdsLS44MS0uMkM5OS42OCwyLjM4LDg3LjIxLDAsNTguMzMsMFoiLz48cGF0aCBjbGFzcz0iY2xzLTEiIGQ9Ik0xMTYuODgsNTUuNThsLS44MS0uMkM5OS42OCw1MS4zOSw4Ny4yMSw0OSw1OC4zMyw0OVMxNy4yLDUxLjM3LjgsNTUuMzJsLS44LjJWOTIuOTRsLjguMTljMTYuNCw0LDI4LjgsNi4zMyw1Ny41Myw2LjMzczQxLjM1LTIuMzksNTcuNzQtNi4zOGwuODEtLjJaIi8+PC9zdmc+&logoWidth=30" alt="Spring Data JPA" height="20">
        </a>
        <a href="https://spring.io/projects/spring-security">
            <img src="https://img.shields.io/badge/Spring_Security-6.5.1-green?logo=spring-security&logoWidth=30" alt="Spring Security" height="20">
        </a>
        <a href="https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/jwt.html">
            <img src="https://img.shields.io/badge/JWT-0.12.5-orange?logo=jsonwebtokens&logoWidth=30&logoColor=orange" alt="JWT" height="20">
        </a>
        <a href="https://mariadb.org/">
            <img src="https://img.shields.io/badge/MariaDB-10.4.32-c0765a?logo=MariaDB&logoWidth=30&logoColor=c0765a" alt="JWT" height="20">
        </a>
        <a href="https://dotenvx.com/">
            <img src="https://img.shields.io/badge/.env-20.6.0-yellow?logo=.ENV&logoWidth=30" alt="JWT" height="20">
        </a>
        <a href="https://www.postman.com/">
            <img src="https://img.shields.io/badge/Postman-10.18.10-FF6C37?logo=postman&logoWidth=30&logoColor=FF6C37" alt="Postman" height="20">
        </a>
    </p>
</div>

### Overview

A REST API built with Spring Boot and JWT (JSON Web Token) for authentication. This project follows a tutorial for learning purposes, focusing on implementing secure API endpoints, role-based access control, and JWT token management.

### Feature

- **JWT-based Authentication** Login, Registration, Token Refresh
- **Role-based Authorization** EMPLOYEE, ADMIN
- **CRUD Operations** for `Task`, `Users`
- **RESTful Standards** HTTP status codes, JSON responses
- **Environment Configuration** using `.env` file (DB, JWT Secret and Admin account)

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

### Configuration

`application.yaml` (partial)

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

# admin
admin:
  email: ${ADMIN_EMAIL}
  password: ${ADMIN_PASSWORD}
```

`.env.example`

```bash
# .env.example

SPRING_DATASOURCE_URL=SPRING_DATASOURCE_URL
SPRING_DATASOURCE_USERNAME=SPRING_DATASOURCE_USERNAME
SPRING_DATASOURCE_PASSWORD=SPRING_DATASOURCE_PASSWORD
SPRING_DATASOURCE_DRIVER_CLASS_NAME=SPRING_DATASOURCE_DRIVER_CLASS_NAME

JWT_SECRET_KEY=JWT_SECRET_KEY
JWT_EXPIRATION_MS=JWT_EXPIRATION_MS

ADMIN_EMAIL=ADMIN_EMAIL
ADMIN_PASSWORD=ADMIN_PASSWORD
```

### Usage

1. **Authentication**

- **Signup**

```http
POST /api/auth/signup
Content-Type: application/json
{ 
    "name": "test",
    "email": "test@example.com",
    "password": "123456"
}
```

- **Login (Get JWT)**

```http
POST /api/auth/login
Content-Type: application/json
{
    "emal": "test@example.com", 
    "password": "123456" 
}
```

**Response:**

> ```json
>{  
>   "Jwt": "YOUR_JWT_TOKEN",
>   "setUserId": "USER_ID",
>   "userRole": "USER_ROLE"
>}
>```

2. **Admin Endpoints**:

- **Create Task**

```http
POST /api/admin/task
Authorization: "Bearer YOUR_JWT_TOKEN"
Content-Type: application/json
{
  "title": "Task title",
  "description": "Task description",
  "dueDate": "2025-07-15",
  "priority": "HIGH",
  "taskStatus": "PENDING",
  "employeeId": 1
}
```

- **Get All Users:**

```http
GET /api/admin/users
Authorization: "Bearer YOUR_JWT_TOKEN"
```

- **Get All Tasks:**

```http
GET /api/admin/tasks
Authorization: "Bearer YOUR_JWT_TOKEN"
```

**Response Example (Success - 200 OK):**

>```json
>[
>   {
>       "id": 1,
>       "title": "Complete project documentation",
>       "description": "Write detailed API documentation",
>       "dueDate": "2023-12-15",
>       "priority": "HIGH",
>       "taskStatus": "IN_PROGRESS",
>       "employeeId": 1,
>       "employeeName": "Doe"
>   },
>   {
>       "id": 2,
>       "title": "Fix authentication bug",
>       "description": "JWT token expiration issue",
>       "dueDate": "2023-12-10",
>       "priority": "URGENT",
>       "taskStatus": "PENDING",
>       "employeeId": 2,
>       "employeeName": "Jane"
>   }
>]
> ```

- **Delete By Id Task:**

```http
DELETE /api/admin/tasks/{id}
Authorization: "Bearer YOUR_JWT_TOKEN"
```

- **Get By Id Task:**

```http
GET /api/admin/tasks/{id}
Authorization: "Bearer YOUR_JWT_TOKEN"
```

### Project Structure

```tree
src/
├── main/
│   ├── java/
│   │   ├── bootstrap/         # Data initializer
│   │   ├── config/            # Security configs, JWT filters
│   │   ├── controller/        # API Controllers
│   │   │   ├── admin/
│   │   │   └── auth/
│   │   ├── dto/               # DTOs
│   │   ├── entities/          # JPA Entities
│   │   ├── enums/             # Enum Types
│   │   ├── repository/        # JPA Repositories
│   │   └── service/           # Business Logic
│   │       ├── admin/
│   │       └── jwt/
│   └── resources/
│       └── application.yaml
├── test/
└── .env.example
```

### Technologies

- **Backend**: Spring Boot 3.x, Spring Security, JWT, Common lang3
- **Database**: MariaDB
- **Tools**: Gradle, Lombok, JPA, Spring Devtools
- **Testing**: JUnit 5, Mockito
- **Other**: Dotenv
