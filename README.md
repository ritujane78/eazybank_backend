# EazyBank Backend : OAUTH2-KEYCLOAK Branch

## Authorization Server
Keycloak authorization server runs on docker with command

    ```bash
        docker run -p http://127.0.0.1:8081:8080 -d \
    -e KC_BOOTSTRAP_ADMIN_USERNAME=admin \
    -e KC_BOOTSTRAP_ADMIN_PASSWORD=admin \
    quay.io/keycloak/keycloak:26.5.0 start-dev
    ```

Keycloak will be available at:
```bash
http://127.0.0.1:8081
```

### Keycloak Configuration Steps

        Create a new Realm

        Create Clients

        Create Users

        Create and assign Roles (USER / ADMIN)

        Configure and enable the required Grant Types for each client

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

| Endpoint                                  | Description                        |
|-------------------------------------------|------------------------------------|
| GET `/myAccount?email=<registered_email>` | View Account Details (only ADMINS) |
| GET `/myBalance?email=<registered_email>` | View Balance (only ADMINS)         |
| GET `/myCards?email=<registered_email>`   | View Card Details (only ADMINS)    |
| GET `/contacts`                           | View Contact Details (public)      |
| GET `/myLoans?email=<registered_email>`   | View Loans (only ADMINS)           |
| GET `/notices`                            | View notices  (public)             |
| GET `/user`                               | Login                              |

JWT is generated here and passed in the header:
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
│   │   └── com.jane
│   │       ├── config
│   │       ├── constants
│   │       ├── controller
│   │       ├── event
│   │       ├── exceptionhandling
│   │       ├── filter
│   │       ├── model
│   │       ├── repository
│   └── resources
│       └── application.properties
```

---

##  Testing

Use **Postman** to test secured APIs.
Ensure JWT tokens are attached to requests where required.

---

