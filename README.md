# Sensor Data Microservice

This microservice generates random sensor data for temperature and humidity, stores the data in a database, and publishes it to a Kafka topic.

## Prerequisites

Ensure you have the following installed:

- Docker
- Docker Compose

## Getting Started

### 1. Clone the Repository
1. Open IntelliJ IDEA.
2. Go to File → New → Project from Version Control...
3. Enter your repository URL and clone the project.

### 2. Run the Project with Docker Compose
To start the entire system (microservice, database, and Kafka):

1. Open the Terminal tab in IntelliJ.
2. Run the following command:
```bash
docker-compose up

```
This will:
- Start the microservice.
- Launch MySql and Kafka as dependencies.
- Expose the microservice on port **8081**.

### 3. Database
Sensor data will be saved in MySql in the table called `sensor_data`.

### 4. Kafka Integration
The microservice will automatically publish sensor data to the Kafka topic.

### 5. Stopping the Project
To stop the containers, run:

```bash
docker-compose down
```