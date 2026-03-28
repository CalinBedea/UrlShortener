# 🔗 URL Shortener API

A full-stack URL shortener application built with **Java 21** and **Spring Boot 3**. This project demonstrates a clean, 3-tier architecture, complete with backend data validation, error handling, and a responsive frontend.

## 🚀 Live Demo
*(Will add the Render link here after deployment! Example: https://my-url-shortener.onrender.com)*

*Note: The project is hosted on a free cloud tier. Please allow ~30 seconds for the server to wake up on the first request.*

## 💻 Tech Stack
* **Backend:** Java 21, Spring Boot 3 (Web, Data JPA, Validation)
* **Database:** PostgreSQL (Hibernate ORM)
* **Build Tool:** Gradle
* **Frontend:** Vanilla HTML/CSS/JS (Dark Theme)
* **Other Tools:** Lombok, RESTful API practices

## ⚙️ Features
* Generate unique 6-character short codes for any valid URL.
* Instant redirection using HTTP 302 Found status.
* Collision prevention in the database.
* Global Exception Handling for clean, readable API responses.
* Mobile-responsive, dark-themed UI.

## 🛠️ Local Setup
1. Clone the repository: `git clone https://github.com/your-username/urlshortener.git`
2. Configure your local PostgreSQL database in `application.properties` or set your environment variables (`DB_USERNAME`, `DB_PASSWORD`).
3. Run the application using your IDE or via command line: `./gradlew bootRun`
4. Access the UI at `http://localhost:8080/`

## 📡 API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/url` | Accepts a JSON body `{"originalUrl": "..."}` and returns the shortened link. |
| `GET` | `/{shortCode}` | Redirects the user to the original long URL. |

---
*Developed by Calin Bedea.*