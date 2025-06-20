Food Delivery API - Spring Boot
A backend REST API for a food delivery app with user registration, JWT login, and role-based access.

Features
User signup & login with JWT

Role-based access (User/Admin)

CRUD for Users, Restaurants, Food Items, and Orders

Spring Security setup

Swagger API docs

MySQL database

Tech Stack
Java 21, Spring Boot 3.2, Spring Security, JPA, MySQL, Swagger, Maven

API Endpoints
Auth:

POST /api/auth/signup – Register

POST /api/auth/login – Login (get JWT)

Users:

GET /api/users – List users

GET /api/users/{id} – Get user

PUT /api/users/{id} – Update user

DELETE /api/users/{id} – Delete user

Food:

POST /api/food – Add food (Admin only)

GET /api/food – List food items

Restaurants:

POST /api/restaurants – Add restaurant

GET /api/restaurants – List restaurants

Orders:

POST /api/orders – Place order

GET /api/orders/user/{userId} – User's orders

Testing
Use Postman or Thunder Client. Add JWT token in headers for secured routes.

