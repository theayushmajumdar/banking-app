# Banking System REST API

This Spring Boot application serves as a REST API for a banking system. It allows users to manage accounts, transactions, users, perform financial operations such as depositing and withdrawing money , and also delete account.

## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
  - [Endpoints](#endpoints)
  - [Authentication](#authentication)
  - [API Testing with Postman](#api-testing-with-postman)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Account Management**: Create, read, update, and delete bank accounts.
- **Transaction Management**: Manage transactions associated with bank accounts.
- **User Management**: Manage users and their roles within the system.
- **Financial Operations**: Perform financial operations such as withdrawing money.
- **RESTful API**: Provides endpoints for seamless integration with client applications.
- **Authentication and Authorization**: Secured endpoints using JWT tokens.

## Technologies

- **Spring Boot**: Framework for building Java-based applications.
- **Spring Security**: Provides authentication and authorization support.
- **Spring Data JPA**: Simplifies data access layer implementation.
- **Hibernate**: ORM (Object-Relational Mapping) framework for mapping Java objects to database tables.
- **MySQL**: Relational database management system.
- **JSON Web Tokens (JWT)**: For securing and authenticating API endpoints.
- **Maven**: Dependency management and build automation tool.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher installed.
- Apache Maven installed.
- MySQL installed and running.

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your_username/banking-system.git
   ```

2. Navigate to the project directory:

   ```bash
   cd banking-system
   ```

3. Update the `application.properties` file in `src/main/resources` with your MySQL database configurations:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
   spring.datasource.username=your_mysql_username
   spring.datasource.password=your_mysql_password
   ```

4. Build the project using Maven:

   ```bash
   mvn clean package
   ```

5. Run the application:

   ```bash
   java -jar target/banking-system.jar
   ```

## Usage

### Endpoints

The API exposes the following endpoints:

- **Accounts**:
  - `GET /accounts`: Retrieve all accounts.
  - `GET /accounts/{accountId}`: Retrieve a specific account by ID.
  - `POST /accounts`: Create a new account.
  - `PUT /accounts/{accountId}`: Update an existing account.
  - `DELETE /accounts/{accountId}`: Delete an account.

- **Transactions**:
  - `GET /accounts/{accountId}/transactions`: Retrieve all transactions for a specific account.
  - `GET /accounts/{accountId}/transactions/{transactionId}`: Retrieve a specific transaction by ID for an account.
  - `POST /accounts/{accountId}/transactions`: Create a new transaction for an account.
  - `PUT /accounts/{accountId}/transactions/{transactionId}`: Update an existing transaction for an account.
  - `DELETE /accounts/{accountId}/transactions/{transactionId}`: Delete a transaction for an account.

- **Users**:
  - `GET /users`: Retrieve all users.
  - `GET /users/{userId}`: Retrieve a specific user by ID.
  - `POST /users`: Create a new user.
  - `PUT /users/{userId}`: Update an existing user.
  - `DELETE /users/{userId}`: Delete a user.

- **Financial Operations**:
  - `POST /operations/withdraw`: Withdraw money from an account.

### Authentication

The API requires authentication for certain endpoints. To authenticate, obtain a JWT token by sending a POST request to `/auth/login` with valid credentials. Include the token in the Authorization header of subsequent requests with the format: `Bearer {token}`.

Example:

```http
POST /auth/login
Content-Type: application/json

{
  "username": "example_user",
  "password": "example_password"
}
```

Response:

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

Include the obtained token in subsequent requests:

```http
GET /accounts
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
```

### API Testing with Postman

[Postman](https://www.postman.com/) is a popular API client that allows you to test API endpoints quickly and efficiently. You can use Postman to send requests to your REST API endpoints and verify their functionality.

#### Getting Started with Postman

1. **Download and Install Postman**:
   - Download and install Postman from the [official website](https://www.postman.com/downloads/).

2. **Import Your API Collection**:
   - If you have an existing Postman collection for your API endpoints, you can import it into Postman.
   - If not, you can manually create requests for each endpoint you want to test.

3. **Send Requests**:
   - Once you have your requests set up in Postman, you can send them to your API endpoints.
   - Make sure your Spring Boot application is running locally or deployed to a server accessible from Postman.

4. **Inspect Responses**:
   - Postman will display the responses from your API endpoints, allowing you to inspect the data returned.
   - You can use this information to verify that your API is functioning correctly.

#### Example Postman Collection

To help you get started, here's an example Postman collection that includes requests for the endpoints in your project:

[Banking System API Collection](link_to_your_postman_collection)

#### Running Tests

You can also use Postman to create and run automated tests for your API endpoints. Postman provides a testing framework that allows you to write scripts to validate responses and ensure that your API behaves as expected.

#### Additional Resources

- [Postman Documentation](https://learning.postman.com/docs/getting-started/introduction/)
- [Postman Learning Center](https://learning.postman.com/)

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License

This project is licensed under the [MIT License](LICENSE).
```

Replace `link_to_your_postman_collection` with the actual link to your Postman collection if you have one. Otherwise, you can leave it as is or remove the placeholder.
