# java-github-workspace-preview

## Customer Feedback REST API

### Overview
Our company recognizes the importance of timely and personalized customer engagement in building brand loyalty and trust. To elevate our customer service experience, we have developed a new customer feedback system.

### Technologies
* Java (21)
* Spring Boot
* PostgreSQL database running inside docker compose for development

### Code Architecture
* Use ports and adapters for the backend code
* Code is covered by unit tests and integration tests

### Out of scope
* Authentication and authorization
* Deployment and infrastructure
* Front-End

### Task Objectives - Develop a Customer Feedback REST API
* Create a new backend REST API that enables customers to submit their feedback securely.
  * Required: User's email address.
    * Validate the email format using regular expressions to ensure data accuracy and prevent spam.
  * Required: The feedback as text.
  * The feedback is stored in an SQL database in UTF-8 encoding.
* Business Benefit: Prepares backend for front-end work with stable backend API that maintains data integrity.

### Email Validation
The Customer Feedback REST API validates the user's email format using regular expressions. This ensures data accuracy and prevents spam.

### Feedback Storage
The feedback is stored in a PostgreSQL database in UTF-8 encoding. This ensures that the feedback text is stored correctly and can handle various characters.

### Starting the Test Database
To start the test database using Docker Compose, follow these steps:
1. Ensure Docker and Docker Compose are installed on your machine.
2. Navigate to the project directory.
3. Run the following command to start the PostgreSQL test database:
   ```sh
   docker-compose up -d
   ```

### Dependency Management
The project uses Maven for dependency management. To build the project and manage dependencies, follow these steps:
1. Ensure Maven is installed on your machine.
2. Navigate to the project directory.
3. Run the following command to build the project:
   ```sh
   mvn clean install
   ```
