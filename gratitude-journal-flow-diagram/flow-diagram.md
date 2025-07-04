# System Design & Flow Diagrams – Gratitude Journal App

This document outlines the technical flow and architecture of the Gratitude Journal App, including class structure, system interactions, CI/CD deployment workflow, and extended API documentation.

---

## 1. Class Diagram

```plaintext
+----------------------+
|     Entry            |
+----------------------+
| - id: Long           |
| - content: String    |
| - date: LocalDate    |
+----------------------+

```

---

## 2. Component Interaction Diagram

```plaintext
[User Interface]
    |
    | (1) User submits gratitude
    v
[Gateway Layer] --------------------------→ [Processor Logic]
                                                |
                                                | (2) Validation + Transformation
                                                v
                                          [Storage Interface]
                                                |
                                                | (3) Save entry in database
                                                v
                                             [Data Layer]

    |
    | (4) User requests past entries
    
 [Database] 
```

---

## 3. REST API Design (Detailed)

### 3.1 Create Entry API

* **Endpoint**: `POST /api/entry`
* **Request Body**:

```json
{
  "content": "I'm grateful for my family."
}
```

* **Response**:

```json
{
  "id": 101,
  "content": "I'm grateful for my family.",
  "date": "2025-07-04"
}
```

* **Response Time SLA**: < 300ms
* **Status Codes**: `201 Created`, `400 Bad Request`, `500 Internal Error`

### 3.2 Fetch All Entries

* **Endpoint**: `GET /api/entry`
* **Response**:

```json
[
  {
    "id": 101,
    "content": "I'm grateful for my family.",
    "date": "2025-07-04"
  },
  {
    "id": 102,
    "content": "Thankful for my health.",
    "date": "2025-07-03"
  }
]
```

* **Response Time SLA**: < 200ms
* **Status Codes**: `200 OK`, `500 Internal Error`

### 3.3 Delete Entry

* **Endpoint**: `DELETE /api/entry/{id}`
* **Response**: `204 No Content`
* **Response Time SLA**: < 250ms
* **Status Codes**: `204`, `404 Not Found`, `500 Internal Error`

---

## 4. Sequence Diagram – From Entry to Deployment

```plaintext
User
  |
  | click 'Submit'       
  v
Frontend App
  | POST /api/entry
  v
Gateway Layer
  | → Processor.save()
  v
Processor Logic
  | → Store.persist()
  v
Data Layer (Entry added)
  | 
  | [Trigger Build Pipeline]
  v
CI/CD System
  | → Run Tests → Lint → Build Image
  | → Push to Container Registry
  v
Cloud Infrastructure
  | → Pull Latest Image
  | → Deploy Updated Service
  v
Updated App Available to Users
```

---

---

## 6. Frontend Folder Structure

```plaintext
/src
 ├── components
 │    ├── EntryForm.jsx
 │    ├── EntryList.jsx
 ├── pages
 │    ├── Home.jsx
 │    ├── History.jsx
 ├── services
 │    ├── api.js
 └── App.jsx
```

---

## 7. Backend Folder Structure

```plaintext
/src/main/java/com/example/app
 ├── interface
 │    └── Gateway.java
 ├── logic
 │    └── Processor.java
 ├── model
 │    └── Entry.java
 ├── storage
 │    └── Store.java
 └── AppLauncher.java
```
## 5. CI/CD and Cloud Deployment Architecture

```plaintext
[Code Repository]
    |
    | (Commit / Push)
    v
[CI/CD Pipeline]
  - Build Application
  - Run Automated Tests
  - Package as Container
  - Push to Registry
    |
    v
[Cloud Platform / VM Instance]
  - Pull Container
  - Stop Old Version
  - Start New Version
    |
    v
[Live URL Available to Users]
```
---

This document now includes core architecture diagrams, API schemas with timings, full DevOps pipeline, and a generic technology-agnostic system flow suitable for implementation and scale.
