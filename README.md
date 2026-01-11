# EazyBank Backend

A **secure, production‑ready Spring Boot backend** for the EazyBank application.

---

##  Frontend

The frontend for this application is written in **Angular**.

**Frontend URL:** https://github.com/ritujane78/eazybank_frontend

---


## Features

This backend includes full security and API support as taught in the
course:

-   Spring Boot REST APIs
  -   Spring Security with JWT-based authentication
    -   Role-based access control (ADMIN / USER)
    -   Custom Security Filters
    -   CSRF & CORS configuration
    -   Method-level security (`@PreAuthorize`, etc.)
    -   Secure password encoding using BCrypt
    -   Authentication & Authorization flows
    -   Exception handling and clean API responses
    -   Environment-specific configuration using Spring Profiles (`default`,
        `prod`)

------------------------------------------------------------------------

## Environment Profiles & Configuration

This backend uses **Spring Profiles** to support environment-specific
configuration and security behavior.

### Available Profiles

-   **`default`** -- Local development and testing\
  -   **`prod`** -- Production-ready configuration

Each profile includes: - A dedicated `application-<profile>.properties`
file - Profile-specific **security configurations** -
Environment-dependent values such as: - Database connections - JWT /
OAuth2 configuration - CORS and CSRF rules

### Runtime Profile Selection

No code changes are required.\
Simply activating a profile automatically enables the corresponding
configuration and security setup.

**Using `application.properties`:**

``` properties
spring.profiles.active=default
```

**Using command line at runtime:**

``` bash
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

This approach reflects **real-world, production-grade Spring Boot
configuration practices**.

------------------------------------------------------------------------

## Branch Overview 

This repository is intentionally structured with multiple branches to demonstrate progressive security implementations.
Each branch highlights a specific security concept and can be reviewed independently.

### `main` branch

The main branch contains the stable, production-ready backend configuration.

In addition to JWT-based security, the code in this branch is fully compatible with a Spring Authorization Server and can be used as a Resource Server.

- Designed to integrate seamlessly with an external OAuth2 Authorization Server.
- Supports token validation and role/authority-based access control.
- Ideal for enterprise architectures where authentication is centralized

 Spring Authorization Server implementation: https://github.com/ritujane78/spring_auth_server

You can run this backend alongside the above authorization server to enable OAuth2-based authentication and authorization flows.

### `oauth2-keycloak` branch


Focuses on:
- OAuth2 implementation using **Keycloak Authorization Server**
  - Externalized authentication and identity management
  - OAuth2 Authorization Code flow
  - Integration tested using **Postman**

This branch demonstrates **enterprise-grade authentication** using an industry-standard IAM solution.

---

### `spring-security-jwttokens` branch

Focuses on:
- JWT-based authentication using Spring Security
  - Custom JWT token generation and validation
  - Stateless authentication without external identity providers
  - Role-based authorization (ADMIN, USER)
  - Custom authentication and authorization filters
  - Secure password encoding using BCrypt

This branch demonstrates a core, from-scratch implementation of Spring Security with JWT, forming a strong foundation for understanding authentication and authorization before introducing OAuth2 and external IAM solutions.

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
jwt.expiration=86400000quit

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


JWT must be passed in the header:
```
Authorization: Bearer <token>
The token can be generated in **Postman** in **Authorization** tab.

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


