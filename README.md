# 📄 Document Microservice – DMS Project

This Spring Boot microservice is responsible for managing **document metadata** within a distributed **Document Management System (DMS)** architecture. It handles categories, departments, and document creation, with full **role-based access control** and **Kafka integration** for title translation.

---

## 🚀 Features

- 🔐 Role-based access: `ROLE_ADMIN` vs `ROLE_USER`
- 📁 Manage document categories & departments (Admin only)
- 📝 Create documents with title, category, department, and owner
- 🕵️ Filter documents based on user's assigned departments
- 🟣 Kafka integration:
  - Sends document titles to `translation_requests`
  - Listens for translated titles on `translation_responses`
- ✅ RESTful API with JSON

---

## 🧱 Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 or MySQL (configurable)
- Apache Kafka (for messaging)
- Maven

---

## 🧪 API Endpoints (Simplified)

### 🔐 Admin Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | `/api/categories` | Create category |
| POST   | `/api/departments` | Create department |
| PUT/DELETE | `/api/categories/{id}` | Update/Delete category |
| PUT/DELETE | `/api/departments/{id}` | Update/Delete department |

---

### 🙋 User Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | `/api/documents` | Create document |
| GET    | `/api/documents` | Get documents (filtered by role) |
| GET    | `/api/documents/search?title=x` | Search by title |

---

## 🟣 Kafka Topics

| Topic | Direction | Description |
|-------|-----------|-------------|
| `translation_requests` | 📨 Producer | Sent when document is created |
| `translation_responses` | 📥 Consumer | Listens for translated title logs |

---

## 🛠️ Getting Started

```bash
# Build the project
./mvnw clean install

# Run the service
./mvnw spring-boot:run
