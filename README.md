# RESTful_APIs_Spring_Boot

# REST API Using Spring Boot

## Overview
This project is a REST API developed for a bookstore using Spring Boot, focusing on providing essential CRUD operations to manage books and users efficiently. The API follows the MVC design pattern, ensuring modularity and clear separation of concerns between components like Controller, Model, Service, DTO, Repository, and Database layers. The entire application integrates with a MySQL database for seamless data storage and retrieval.

## Key Features
- **CRUD Operations**: Implemented Create, Read, Update, and Delete operations to manage bookstore data.
- **Exception Handling**: Ensured robust exception management to handle errors gracefully and provide meaningful responses.
- **Status Code Management**: Proper handling of HTTP status codes to communicate the success or failure of API requests.
- **Database Integration**: Utilized MySQL for data manipulation and storage, ensuring smooth interaction with the API.
- **Thorough Testing**: All APIs were tested using Postman to ensure reliability and correct functionality.

## Technical Stack
- **Framework**: Spring Boot
- **Database**: MySQL
- **Architecture**: MVC (Model-View-Controller)
- **API Testing**: Postman

## Project Structure
```
bootrestbook
│── .mvn/wrapper
│   ├── maven-wrapper.jar
│   ├── maven-wrapper.properties
│── src
│   ├── main/java/com/api/book
│   │   ├── controller
│   │   │   ├── BookController.java
│   │   ├── dao
│   │   │   ├── BookRepository.java
│   │   ├── entities
│   │   │   ├── Book.java
│   │   ├── services
│   │   │   ├── BookService.java
│   │   ├── BootrestbookApplication.java
│   │   ├── resources
│   │   │   ├── application.properties
│   ├── test/java/com/api/book
│── .gitignore
│── mvnw
│── mvnw.cmd
│── pom.xml
│── README.md
```

## Setup Instructions
1. Clone the repository:
   ```sh
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```sh
   cd bootrestbook
   ```
3. Configure the MySQL database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/bookstore
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```
4. Build and run the project:
   ```sh
   mvn spring-boot:run
   ```
5. Test the API using Postman or any API client.

## Endpoints
| Method | Endpoint       | Description             |
|--------|--------------|-------------------------|
| GET    | /books       | Get all books          |
| GET    | /books/{id}  | Get book by ID         |
| POST   | /books       | Add a new book         |
| PUT    | /books/{id}  | Update an existing book |
| DELETE | /books/{id}  | Delete a book          |

## License
This project is licensed under the MIT License.
