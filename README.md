# DevCoder AI Assistant 🚀

DevCoder AI Assistant is an AI-powered coding assistant developed using **Spring Boot**, **Thymeleaf**, **MySQL**, and **Ollama with Llama 3.2**.  
The application allows users to ask programming-related questions and receive AI-generated code responses in real time.

---

# 📌 Features

- AI-powered coding assistant
- Real-time code generation
- Chat-based user interface
- Conversation history management
- Sidebar session navigation
- Delete chat conversations
- MySQL database integration
- Ollama LLM integration
- AWS EC2 cloud deployment
- Responsive UI using HTML & CSS

---

# 🛠 Technologies Used

## Backend
- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- WebClient

## Frontend
- HTML5
- CSS3
- Thymeleaf

## Database
- MySQL

## AI / LLM
- Ollama
- Llama 3.2

## DevOps / Deployment
- AWS EC2
- Ubuntu Server
- Git & GitHub

---

# 🤖 AI Model Used

## Ollama
Ollama is used to run Large Language Models (LLMs) locally or on a dedicated AI server.

Official Website:  
https://ollama.com

## Llama 3.2
This project uses the **Llama 3.2** model for generating coding-related responses.

Example model:

```bash
ollama pull llama3.2
```

The model is used for:
- Java Programming
- Spring Boot Development
- SQL Queries
- Web Development
- Coding Assistance

---

# 🏗 System Architecture

```text
User Browser
      ↓
Spring Boot Application
      ↓
Ollama API Server
      ↓
Llama 3.2 Model
      ↓
Generated AI Response
```

---

# 📂 Project Structure

```text
src
 ├── main
 │   ├── java
 │   │   └── com.chatbot.devcoder
 │   │        ├── controller
 │   │        ├── model
 │   │        ├── repository
 │   │        └── service
 │   │
 │   └── resources
 │        ├── templates
 │        └── application.properties
```

---

# 🗄 Database Table

## chat_session

| Column | Type |
|---|---|
| id | BIGINT |
| question | VARCHAR |
| answer | TEXT |
| created_at | DATETIME |

---

# ⚙️ How It Works

1. User enters a coding question
2. Spring Boot controller receives the request
3. Service layer sends prompt to Ollama API
4. Llama 3.2 generates the response
5. Response is stored in MySQL database
6. Chat history is displayed in the sidebar

---

# ☁ AWS Deployment

This project is deployed using **two AWS EC2 servers**.

## Server 1
### Spring Boot + MySQL
Responsible for:
- Backend API
- Frontend rendering
- Database management

## Server 2
### Ollama + Llama 3.2
Responsible for:
- Running AI models
- Generating AI responses

---

# 🚀 Deployment Steps

## 1. Clone Repository

```bash
git clone https://github.com/Ashwini6/devCoder.git
```

---

## 2. Install Java & Maven

```bash
sudo apt update

sudo apt install openjdk-17-jdk -y

sudo apt install maven -y
```

---

## 3. Install MySQL

```bash
sudo apt install mysql-server -y
```

Create database:

```sql
CREATE DATABASE devcoder;
```

---

## 4. Configure application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/devcoder
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update

server.port=8090
```

---

## 5. Install Ollama

```bash
curl -fsSL https://ollama.com/install.sh | sh
```

---

## 6. Pull Llama 3.2 Model

```bash
ollama pull llama3.2
```

---

## 7. Run Ollama

```bash
ollama serve
```

---

## 8. Run Spring Boot Application

```bash
mvn spring-boot:run
```

OR

```bash
java -jar target/*.jar
```

---

# 🔥 AWS Ports Configuration

| Service | Port |
|---|---|
| Spring Boot | 8090 |
| Ollama | 11434 |
| MySQL | 3306 |

---


# 🔐 Security Improvements

- Restrict Ollama server access
- Store secrets securely
- Use HTTPS with Nginx
- Add authentication & authorization

---

GitHub:  
https://github.com/Ashwini6

