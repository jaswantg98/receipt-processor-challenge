# Receipt Processor Challenge

This project implements a receipt processing service that awards points based on specific rules. The service provides two main functionalities:

1. **Process Receipt**: Submits a receipt for processing and returns an ID.
2. **Get Points**: Retrieves the points awarded for a given receipt ID.

## Table of Contents
- [Requirements](#requirements)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
  - [Process Receipt](#process-receipt)
  - [Get Points](#get-points)
- [Testing](#testing)
- [License](#license)

## Requirements
- **Java 11** or higher
- **Maven** (for dependency management)
- **Docker** (optional, for containerized deployment)

## Installation

### Using Maven
1. Clone the repository:
    ```bash
    git clone https://github.com/jaswantg98/receipt-processor-challenge.git
    cd receipt-processor-challenge
    ```

2. Build the project using Maven:
    ```bash
    mvn clean install
    ```

### Using Docker
1. Build the Docker image:
    ```bash
    docker build -t receipt-processor-challenge .
    ```

2. Run the Docker container:
    ```bash
    docker run -p 8080:8080 receipt-processor-challenge
    ```

## Usage

### Running the Application
- **With Maven**: Run the application using:
  ```bash
  mvn spring-boot:run
  ```
- **With Docker**: Start the Docker container as shown above.

### Accessing the API
Once the application is running, you can access the API at `http://localhost:8080`.

## API Endpoints

### Process Receipt
- **Endpoint**: `/receipts/process`
- **Method**: `POST`
- **Payload**: JSON object representing the receipt
- **Response**: JSON object with the ID of the processed receipt

#### Example Request
```json
{
  "retailer": "M&M Corner Market",
  "purchaseDate": "2022-03-20",
  "purchaseTime": "14:33",
  "items": [
    {
      "shortDescription": "Gatorade",
      "price": "2.25"
    },{
      "shortDescription": "Gatorade",
      "price": "2.25"
    },{
      "shortDescription": "Gatorade",
      "price": "2.25"
    },{
      "shortDescription": "Gatorade",
      "price": "2.25"
    }
  ],
  "total": "9.00"
}

#### Example Response
```json
{
    "id": "383c8d0e-3deb-4cf8-afbf-7d2877a8b6fb"
}

### Get Points
- **Endpoint**: `/receipts/{id}/points`
- **Method**: `GET`
- **Response**: JSON object with the points awarded for the given receipt ID

#### Example Response
{
    "points": 109
}
