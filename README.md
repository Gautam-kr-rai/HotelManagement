# Hotel Management System (Backend)

## Overview
This project is a **Hotel Management System** built using **Spring Boot**, following a **microservices architecture**. It includes independent services for managing hotel data and ratings, ensuring modularity and scalability.

## Features
- **Microservices Architecture**: Decoupled services for hotel management and ratings.
- **Rating Service**: Separate microservice for handling hotel ratings independently.
- **CRUD Operations**: Implemented for both hotel and rating services.
- **RESTful APIs**: Configured for seamless inter-service communication and data exchange.
- **Scalability**: Modular design for easy future expansion and maintenance.

## Tech Stack
- **Backend**: Spring Boot, Spring Web, Spring Data JPA
- **Database**: MySQL
- **Dependencies**: Lombok, Spring Boot Starter Web, Spring Boot Starter Data JPA
- **API Communication**: REST APIs

## Installation & Setup
1. **Clone the repository:**
   ```bash
   git clone <repository-link>
   cd hotel-management-system
   ```

2. **Configure MySQL Database:**
   - Update `application.properties` with your MySQL credentials.

3. **Build and Run the Application:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## API Endpoints
### Hotel Service
- **Create a hotel**: `POST /hotels`
- **Get all hotels**: `GET /hotels`
- **Get a hotel by ID**: `GET /hotels/{id}`
- **Update a hotel**: `PUT /hotels/{id}`
- **Delete a hotel**: `DELETE /hotels/{id}`

### Rating Service
- **Add a rating**: `POST /ratings`
- **Get ratings by hotel ID**: `GET /ratings/hotel/{hotelId}`
- **Update a rating**: `PUT /ratings/{id}`
- **Delete a rating**: `DELETE /ratings/{id}`

## Microservices Architecture
- **Hotel Service**: Manages hotel-related data.
- **Rating Service**: Handles hotel ratings separately.
- **Inter-Service Communication**: RESTful API calls for data exchange between services.

## Future Enhancements
- Implement authentication and authorization.
- Add caching mechanisms for improved performance.
- Integrate a frontend for better user experience.

## Contributing
Feel free to fork the repository and submit pull requests for enhancements or bug fixes.
---
