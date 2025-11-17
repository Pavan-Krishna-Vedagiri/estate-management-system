# 🚀 Spring Boot REST API

A lightweight and modular RESTful API built with Spring Boot. This project demonstrates clean architecture, RESTful conventions, and efficient coding practices including proper endpoint naming, DI, and exception handling.

---

## 📦 Features

- ✅ RESTful CRUD operations
- 🔄 Proper use of `@PutMapping`, `@PostMapping`, `@GetMapping`, and `@DeleteMapping`
- 🧩 Dependency Injection with Spring's IoC container
- 🛡️ Security-conscious design (authentication-ready)
- 🧪 Unit and integration test-ready structure
- ⚙️ Optimized for Eclipse workflow (shortcuts, auto-format, import cleanup)

---

## 🛠️ Tech Stack

| Layer        | Technology        |
|--------------|-------------------|
| Language     | Java 17+          |
| Framework    | Spring Boot       |
| Build Tool   | Maven /           |

---

## 📂 Project Structure


---

## 🔧 API Endpoints

### 👤 User Controller

| Method | Endpoint         | Description              |
|--------|------------------|--------------------------|
| GET    | `api/users/{id}` | Get user by ID           |
| POST   | `api/users`      | Create new user          |
| PUT    | `api/users/{id}` | Update existing user     |
| DELETE | `api/users/{id}` | Delete user              |

---

## 🧪 Running the App

```bash
# Build the project
./mvnw clean install

# Run the application
./mvnw spring-boot:run
