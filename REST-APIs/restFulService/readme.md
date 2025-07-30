# 🌐 Spring Boot RESTful Web Service

This is a simple yet well-structured Spring Boot application that demonstrates how to build a RESTful web service following best practices — even in a minimal example.

## 📖 Description

This project exposes a single REST endpoint that returns a greeting message. It's based on the Spring guide: **Building a RESTful Web Service**.

- Endpoint: `GET /greeting`
- Optional query parameter: `name`
- Returns a greeting message with a unique ID.

Example usage:

# GET /greeting?name=Ayush

Response:
```json
{
  "id": 1,
  "content": "Hello Ayush!"
}
```
If no name is provided:
```json
{
  "id": 2,
  "content": "Hello World!"
}
```

# 📦 Project Structure

```text
src/
└── com.restFulService
    ├── controller
    │   └── GreetingController.java
    └── model
        └── Greeting.java
```
# 💡 Key Concepts & Best Practices
✅ AtomicLong

* Used to generate a thread-safe, incrementing ID for each greeting.

* Prevents race conditions in a concurrent environment (e.g., multiple requests coming in simultaneously).

* Better than long when your controller is handling high-traffic or multi-threaded operations.

```java
private final AtomicLong countId = new AtomicLong();
```

✅ Java record

* The Greeting class is implemented as a record — a Java feature introduced in Java 14+ to create simple data carriers (immutable by default).

```java
public record Greeting(long id, String content) {}
```
Benefits:

* Concise syntax

* Immutable and thread-safe

* Auto-generates constructor, getters, equals, hashCode, and toString

✅ ResponseEntity<T>

* Gives you full control over the HTTP response.

* Allows setting status codes (200 OK, 400 Bad Request, etc.) and headers.

* Makes your API responses more explicit and professional.

```java
return ResponseEntity.status(HttpStatus.OK).body(...);
```
# 📦 Technologies Used

* Java 17+

* Spring Boot

* Maven

* REST API

# 🧪 How to Run
```maven
./mvnw spring-boot:run
```

Then open your browser at:

http://localhost:8080/greeting?name=YourName

# 📚 Reference

Guide used:
[Spring.io - Building a RESTful Web Service](https://spring.io/guides/gs/rest-service)