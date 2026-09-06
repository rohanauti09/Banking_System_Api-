# 🏦 Banking System – Spring Boot Backend

A backend banking system built using Spring Boot, Spring Data JPA, MySQL, and RESTful APIs.  
Originally implemented in Core Java and later refactored to Spring Boot following industry-standard backend architecture and best practices.

---

## 🚀 Features

- Create and manage users  
- Create bank accounts  
- Deposit and withdraw money  
- Transfer money between accounts (atomic & transactional)  
- Check account balance  
- Implemented caching to optimize read-heavy operations  

---

## 🛠️ Tech Stack

- Java 17  
- Spring Boot  
- Spring Data JPA (Hibernate)  
- MySQL  
- Spring Cache (In-Memory Caching)  
- REST APIs  
- Maven  
- Postman (API Testing)  

---

## 🧩 Project Architecture

The project follows a layered architecture:

### Controller Layer
Handles REST API requests and responses.

### Service Layer
Contains business logic such as deposit, withdraw, transfer, and caching.

### Repository Layer
Uses Spring Data JPA to interact with the database.

### Model Layer
JPA entities representing database tables.

---

## 🔁 Key Backend Concepts Implemented

### 💰 Transaction Management
- Implemented using `@Transactional`  
- Ensures atomic operations for fund transfers  
- Prevents partial updates and maintains data consistency  

### ⚡ Caching Strategy
- Implemented using Spring Cache (`@Cacheable`, `@CachePut`, `@CacheEvict`)  
- Optimizes frequently accessed data (account balance)  
- Reduces redundant database calls  
- Maintains cache consistency by updating/evicting cache on data modification  

### 🧠 Service Design
- Centralized business logic in `AccountService`  
- Ensures single source of truth for account operations  
- Prevents cache inconsistency and duplicate logic  

---

## 🌐 REST API Endpoints

### 👤 User APIs
| Method | Endpoint | Description |
|-------|--------|------------|
| POST | /users | Create a new user |

### 🏦 Account APIs
| Method | Endpoint | Description |
|-------|--------|------------|
| POST | /accounts | Create account |
| PUT | /accounts/deposit | Deposit money |
| PUT | /accounts/withdraw | Withdraw money |
| PUT | /accounts/transfer | Transfer money |
| GET | /accounts/balance | Get account balance |

---

## ⚙️ Database Design

- MySQL relational database  
- Auto-generated primary keys for internal use  
- Business identifiers:
  - `userId`
  - `accountNumber`  
- Foreign key relationships ensure referential integrity  

---

## ▶️ How to Run the Project

1. Clone the repository  
2. Create a MySQL database  
3. Configure database credentials in `application.properties`  
4. Run the application:
