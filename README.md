# 🍽️ Food Delivery Application - Spring Boot Project

This is a full-stack **Spring Boot REST API** for a Food Delivery application, developed as a backend service. It supports user registration, JWT-based login, food item management, order placement, and restaurant management.

---

## 🚀 Features

- ✅ **User Registration & Login** with JWT Authentication
- ✅ **Role-based Access Control** (User/Admin)
- ✅ **CRUD APIs** for:
  - Users
  - Restaurants
  - Food Items
  - Orders
- ✅ **Spring Security** configuration
- ✅ **Swagger/OpenAPI** documentation
- ✅ **MySQL Database** integration

---

## 📦 Technologies Used

- Java 21
- Spring Boot 3.2.5
- Spring Security
- Spring Data JPA
- MySQL
- Swagger (Springdoc OpenAPI v2.5.0)
- Maven
- Thunder Client / Postman for testing

---

## 🛠️ API Endpoints

### 🔐 Authentication
- `POST /api/auth/signup` – Register a new user
- `POST /api/auth/login` – Login and get JWT token

### 👤 Users
- `GET /api/users` – List all users
- `GET /api/users/{id}` – Get user by ID
- `PUT /api/users/{id}` – Update user
- `DELETE /api/users/{id}` – Delete user

### 🍔 Food
- `POST /api/food` – Add new food (Admin)
- `GET /api/food` – View all food items

### 🏬 Restaurants
- `POST /api/restaurants` – Add new restaurant
- `GET /api/restaurants` – List all restaurants

### 📦 Orders
- `POST /api/orders` – Place a new order
- `GET /api/orders/user/{userId}` – Get all orders for user

---

## 🧪 Testing

- Use **Thunder Client** or **Postman**
- Add JWT token in headers:
