# EazyBank Backend : SPRING-SECURITY-JWTTOKENS Branch

Focuses on:
- JWT-based authentication using Spring Security
- Custom JWT token generation and validation
- Stateless authentication without external identity providers
- Role-based authorization (ADMIN, USER)
- Custom authentication and authorization filters
- Secure password encoding using BCrypt

This branch demonstrates a core, from-scratch implementation of Spring Security with JWT, forming a strong foundation for understanding authentication and authorization before introducing OAuth2 and external IAM solutions.

##  Frontend

The frontend for this application is written in **Angular**.

**Frontend URL:** https://github.com/ritujane78/eazybank_frontend

---

##  Features

This backend includes full security and API support as taught in the course:

- Spring Boot REST APIs
- Spring Security with JWT-based authentication
- Role-based access control (ADMIN / USER)
- Custom Security Filters
- CSRF & CORS configuration
- Method-level security (`@PreAuthorize`, etc.)
- Secure password encoding using BCrypt
- Authentication & Authorization flows
- Exception handling and clean API responses

---

##  Tech Stack

| Layer | Technology |
|------|-----------|
| Backend | Java 17+, Spring Boot |
| Security | Spring Security, JWT |
| Build Tool | Maven |
| Database | MySQL |
| API | REST |
| Frontend | Angular (separate repository) |

---

##  Getting Started

### Prerequisites

- Java 17+
- Maven 3.6+
- MySQL
- Postman (for testing)

---

### Setup Instructions

1. **Clone the repository**
```bash
git clone https://github.com/ritujane78/eazybank_backend.git
cd eazybank_backend
```

2. **Configure application properties**

Update `application.properties`:

```properties
spring.datasource.url=jdbc:YOUR_DATABASE_URL
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD

jwt.secret=YOUR_SECRET_KEY
jwt.expiration=86400000
```

3. **Build & Run**
```bash
mvn clean install
mvn spring-boot:run
```

---

##  API Overview

| Endpoint | Description |
|--------|-------------|
| POST `/api/auth/register` | Register a new user |
| POST `/api/auth/login` | Authenticate and receive JWT |
| GET `/api/user/**` | Secured user APIs |
| GET `/api/admin/**` | Admin-only APIs |

JWT must be passed in the header:
```
Authorization: Bearer <token>
```

---

## Security Highlights

- Custom JWT authentication filter
- Stateless session management
- Role & authority-based authorization
- CORS and CSRF configuration
- Secure password storage

---

##  Project Structure

```
src
├── main
│   ├── java
│   │   └── com.eazybank
│   │       ├── config
│   │       ├── controller
│   │       ├── dto
│   │       ├── entity
│   │       ├── repository
│   │       ├── security
│   │       └── service
│   └── resources
│       └── application.properties
```

---

##  Testing

Use **Postman** to test secured APIs.
Ensure JWT tokens are attached to requests where required.

---

##  Deployment

The application can be deployed using:
- Docker
- AWS
- Azure
- Heroku

---
