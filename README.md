xlsx-to-db-uploader

Overview
The xlsx-to-db-uploader is a Spring Boot application designed to upload .xlsx files and persist their data into a database. This project leverages Apache POI for handling Excel files and Spring Data JPA for database operations.

Features
📂 Upload .xlsx files via a RESTful API.

🔍 Parse and validate Excel file content.

🗄️ Persist data from Excel files into a relational database.

⚠️ Error handling and logging.

Prerequisites
☕ Java 17 or later

📦 Maven 3.8.1 or later

🐬 MySQL 8.0 or later

Getting Started
git clone https://github.com/obinnaee2/xlsx-to-db-uploader.git

cd xlsx-to-db-uploader

Configuration
Database Configuration

spring.datasource.url=jdbc:mysql://localhost:3306/yourdatabase
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

API Endpoints
The application provides the following REST API endpoints:

Upload Excel File

URL: /api/upload

Method: POST

Content-Type: multipart/form-data

Parameter: file (The .xlsx file to upload)

Example using Postman

Open Postman.

Set the request type to POST.

Enter the URL http://localhost:8080/api/upload.

Navigate to the Body tab.

Select form-data.

Add a key file with the value as your .xlsx file.

Click on Send.

Retrieve All Data

URL: /api/data

Method: GET

Description: Retrieves all data persisted in the database.

Example using Postman

Open Postman.

Set the request type to GET.

Enter the URL http://localhost:8080/api/data.

Click on Send.

Example Response
{
  "message": "File uploaded and data persisted successfully",
}






