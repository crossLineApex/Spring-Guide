# 🌐 Spring Boot Hypermedia-Driven RESTful Web Service

This is a simple yet well-structured Spring Boot application that demonstrates how to build a RESTful web service following best practices — even in a minimal example.

## 📖 Description

This project exposes a single REST endpoint that walks you through the process of creating a “Hello, World” Hypermedia-driven REST web service with Spring.. It's based on the Spring guide: 
**Building a Hypermedia-Driven RESTful Web Service**.

- Endpoint: `GET /greeting`
- Optional query parameter: `name`
- Returns a greeting message with _link.

Example usage:

# GET /greeting?name=Ayush

Response:
```json
{
  "content": "Hello, Ayush!",
  "_links": {
    "self": {
      "href": "http://localhost:8080/greeting?name=Ayush"
    }
  }
}
```
If no name is provided:
```json
{
  "content": "Hello, World!",
  "_links": {
    "self": {
      "href": "http://localhost:8080/greeting?name=World"
    }
  }
}
```

# 📦 Project Structure

```text
src/
└── com.resthateoas
    ├── controller
    │   └── GreetingController.java
    └── model
        └── Greeting.java
```
# 💡 Key Concepts & Best Practices
✅ Representation Model

* Greeting extends RepresentationModel<Greeting> to enable hypermedia support via HATEOAS.

* This base class provides a _links property that holds hypermedia links, allowing clients to navigate the REST API dynamically.

```java
public class Greeting extends RepresentationModel<Greeting>
```



✅ JSON Serialization
* @JsonCreator and @JsonProperty are Jackson annotations used to:

    * @JsonCreator: Instruct Jackson how to instantiate the object from JSON.

    * @JsonProperty: Map constructor parameters to JSON fields.

* These enable Spring to serialize/deserialize Greeting objects seamlessly in HTTP requests/responses.

✅ Hypermedia (HATEOAS)
* The controller method adds a self-link using:

```java
greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());
```
* This creates a _links.self.href entry in the JSON, enabling hypermedia-driven client navigation.

# 📦 Technologies Used

* Java 17+

* Spring Boot

* Maven

* REST API

* Spring HATEOAS

# 🧪 How to Run
```maven
./mvnw spring-boot:run
```

Then open your browser at:

http://localhost:8080/greeting?name=YourName

# 📚 Reference

Guide used:
[Spring.io - Building a Hypermedia-Driven RESTful Web Service
](https://spring.io/guides/gs/rest-hateoas)