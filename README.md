📁 Spring Boot File Upload and Validation API
A powerful Spring Boot-based REST API that supports file upload/download, custom input validation, and user data processing — equipped with Swagger/OpenAPI for documentation and inspection.

✨ Features
    ✅ Upload and download files (binary storage)
    ✅ View all uploaded files via /all
    ✅ Custom validation using annotations (e.g., no special characters)
    ✅ Basic user management using DTOs and validation constraints
    ✅ Live interactive API docs with Swagger UI
    ✅ Layered architecture (Controller → Service → Repository)

📦 Project Structure

com.dev.validatiom
├── Config                # Swagger configuration
├── controller            # REST Controllers
├── dto                  # Data Transfer Objects
├── model                # JPA Entities
├── repo                 # Spring Data JPA Repositories
├── service              # Business Logic Layer
└── validation           # Custom input validations

🔧 Technologies Used

| Tech               | Version / Info      |
| ------------------ | ------------------- |
| Java               | 21 (LTS)            |
| Spring Boot        | Latest Stable       |
| Spring Web         | RESTful APIs        |
| Spring Data JPA    | ORM                 |
| H2/MySQL           | Database Support    |
| Jakarta Validation | Input Constraints   |
| Swagger / OpenAPI  | `springdoc-openapi` |
| Lombok             | Reduces boilerplate |

🧪 API Endpoints
📁 File API – /api/v1/files
Method	Endpoint	Description
POST	/upload	Upload a file
GET	/download/{id}	Download a file by ID
GET	/all	List all uploaded files

👤 User API – /api/v1
Method	Endpoint	Description
POST	/users	Create user (raw model)
POST	/postUser	Create user (validated DTO)
GET	/hello	Sample hello endpoint
GET	/add	Returns 2 + 4 = 6 (demo logic)

🛡️ Custom Validation Example

@NoSpecialChar
private String firstname;

public class NoSpecialCharsValidator implements ConstraintValidator<NoSpecialChar, String> {
    public static final String DISALLOWED_REGEX = ".*[<>@#\\\\$%&*].*";
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value == null || !value.matches(DISALLOWED_REGEX);
    }
}
🔍 Swagger/OpenAPI Integration

Swagger is available at:
http://localhost:8080/swagger-ui/index.html
It allows real-time testing and viewing of all REST endpoints.
To enable it, the following dependency is added:

<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.8.9</version>
</dependency>

✅ Getting Started
1. Clone the project:
git clone https://github.com/Catus07/Spring-Boot-File-Upload-and-Validation-API.git

2. Build and run:
./mvnw spring-boot:run

3. Test endpoints via:
    Postman
    Swagger UI

📚 Author
 Revocatus Joseph Nduki
    Spring Boot Developer, Cybersecurity Enthusiast
