# 🌼 Gratitude Journal – Front-End (Angular) Documentation

## 📌 Project Overview

This is the **front-end Angular app** for the Gratitude Journal. It follows a **strict, minimalist UI system** designed to encourage calmness, emotional clarity, and simplicity. This app connects to a Spring Boot RESTful API to manage gratitude entries.

---

## 🎯 UI Design Principles (Strict Guidelines)

* **Font**: Inter (Google Fonts)
* **Color Palette**:

    * Background: `#F98F63`
    * Button Background: `#FBC252`
    * Button Text: `#FFFFFF`
    * Heading Text: `#333333`
    * Input Field: `#F4F4F4`
    * Border Color: `#DDDDDD`
    * Success Message: `#28A745`
* **Typography**:

    * Heading: 28px, weight 600
    * Subheading: 20px, weight 400
    * Body: 16px, weight 400
    * Button: 16px, weight 500
* **Spacing**:

    * Container: 90% width, max 420px
    * Vertical spacing: 24px
    * Whitespace around text: 16px
* **Button**: Rounded, height: 48px, 80–100% width
* **Emoji**: One 🙂 emoji at the top center of landing page

---

## 🔗 API Endpoints

### 1. ➕ Add Entry

* **Endpoint**: `POST /api/journal/add`
* **Request Body**:

```json
{
  "content": "I am grateful for a productive and peaceful day."
}
```

* **Response**: `201 Created`

```json
{
  "id": 1,
  "content": "I am grateful for a productive and peaceful day.",
  "createdAt": "2025-07-05T10:40:12"
}
```

### 2. 📄 Get All Entries

* **Endpoint**: `GET /api/journal/allEntries`
* **Response**:

```json
[
  {
    "id": 1,
    "content": "I am grateful for a productive and peaceful day.",
    "createdAt": "2025-07-05T10:40:12"
  },
  {
    "id": 2,
    "content": "Thankful for supportive friends and good health.",
    "createdAt": "2025-07-05T10:45:00"
  }
]
```

### 3. ❌ Delete Entry

* **Endpoint**: `DELETE /api/journal/delete/{id}`
* **Example**:

```http
DELETE /api/journal/delete/1
```

* **Response**: `204 No Content`

---

## 🛠️ Setup & Run Instructions

### 1. 📦 Install Dependencies

```bash
npm install
```

### 2. 🚀 Run the Application

```bash
ng serve
```

Then open `http://localhost:4200` in your browser.

### 3. 🧪 Test Backend

Ensure the Spring Boot backend is running at:

```http
http://localhost:8080
```

---

## 💡 Project Structure Suggestions

```
src/
├── app/
│   ├── components/
│   │   └── journal-entry-form/
│   ├── services/
│   │   └── journal.service.ts
│   ├── pages/
│   │   └── home/
│   └── app.module.ts
├── assets/
│   └── styles/
│       └── theme.css (matching the UI system)
└── index.html
```

---

## 📌 Notes

* **Responsiveness**: Optimized for mobile-first layout.
* **Accessibility**: WCAG-compliant contrast, 16px+ font size, `aria-labels`.
* **Strict UI Compliance**: No deviation from design rules.

---

> "Gratitude unlocks the fullness of life." – Keep logging, keep glowing. 🌟
