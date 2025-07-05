# Database Schema – Gratitude Journal App (H2 In-Memory)

This document defines the **Version 1.2** database schema for the Gratitude Journal App using the **H2 in-memory database**, tailored to support the current single-user, minimal journaling UI.

---

## 1. Table: `entry`

The core table for storing gratitude messages.

```sql
CREATE TABLE entry (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(1000) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### Description

| Column      | Type          | Description                       |
| ----------- | ------------- | --------------------------------- |
| id          | BIGINT        | Unique identifier                 |
| content     | VARCHAR(1000) | Gratitude message from user       |
| created\_at | TIMESTAMP     | Time of entry creation (auto-set) |

### Sample Insert

```sql
INSERT INTO entry (content) VALUES ('Grateful for having peaceful time.');
```

---

## 2. H2 Console Configuration (Spring Boot)

```properties
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:gratitude
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
```

---

## 3. Future Roadmap (High-Level Schema Preview)

| Version | Schema Highlights                                                        |
| ------- | ------------------------------------------------------------------------ |
| 1.2     | Single `entry` table, no user context                                    |
| 2.0     | Adds `users` table, journaling `streak_day`, mood tag, and relationships |

No joins, no foreign keys in Version 1.2 — keeping it **lightweight, fast, and focused** just like the app’s current experience.

This version supports the clean, emotional, form-first user experience seen in the current UI.
