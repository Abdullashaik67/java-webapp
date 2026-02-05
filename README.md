# Item Management REST API

## Description
This is a simple Spring Boot application that provides RESTful APIs
to manage items using in-memory storage.

## Technologies Used
- Java 17
- Spring Boot
- Maven
- REST API

## How to Run
1. Install Java 17
2. Open terminal in project folder
3. Run:
   mvnw spring-boot:run
4. Application runs on:
   http://localhost:8080

## API Endpoints

### Add Item
POST /api/items

Request Body:
{
  "id": 100,
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 75000
}

### Get Item by ID
GET /api/items/{id}

Example:
GET /api/items/100

## Notes
- Uses in-memory ArrayList
- Data resets when application restarts
