![Status](https://img.shields.io/badge/status-finished-green)

## Description

**WalletFlow API** is a personal financial control API developed in Java using Spring Boot and based on Clean Architecture. The project helps users organize income and expenses in a structured and secure way, with categorization and analysis features for better financial planning.

## Technologies

- **Java 23**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL for data storage**

## Project Structure

The project follows Clean Architecture, separating responsibilities into clear layers for easy maintenance and scalability:

- **Controllers**: Receive and process HTTP requests.
- **Use Cases**: Business logic and main operations.
- **Repositories**: Interface with the database.
- **Entities**: Definition of domain models and entities.

## How to Run

1. Clone the repository:

```bash
git clone https://github.com/kaiquefreire05/walletFlowApi.git
cd walletFlowApi
```

2. Configure the `application.properties` file with the MySQL connection string.

3. Start the application with Maven:

```bash
./mvnw spring-boot:run
```

4. Access `http://localhost:8080` to interact with the API.

## Main Endpoints

- **POST /api/auth/register**: User registration.
- **POST /api/auth/login**: User authentication.
- **GET /api/transactions**: List of transactions.
- **POST /api/transactions**: Add a new transaction.

> Detailed documentation is not available in Swagger.

## Contributing

1. Fork the project.
2. Open a branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m 'Feature Description'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a Pull Request.

## License

Distributed under the MIT License. See `LICENSE` for more details.

---

This README includes a general description, installation and running instructions, and details about the structure and main endpoints.
