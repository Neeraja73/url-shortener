# 🔗 Spring Boot URL Shortener

A scalable URL Shortening service built using Spring Boot following SOLID principles and design patterns.

## 🚀 Features

- Shorten long URLs
- Custom short code generation
- Expiration support
- Redirection to original URL
- Global exception handling
- Clean layered architecture

---

## 🏗️ Architecture

Controller → Service → Repository → Database

### Design Patterns Used:
- Strategy Pattern (Code Generation)
- Repository Pattern
- Observer Pattern (Analytics tracking)
- Global Exception Handling

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Maven
- H2 / MySQL (if used)
- REST APIs

---

## 📌 API Endpoints

### 1️⃣ Shorten URL

POST `/api/shorten`

Example:
http://localhost:8080/api/shorten?url=https://google.com


Response:
http://localhost:8080/abc123


---

### 2️⃣ Redirect

GET `/{shortCode}`

Redirects to original long URL.

---

## ▶️ How to Run

```bash
mvn clean install
mvn spring-boot:run



