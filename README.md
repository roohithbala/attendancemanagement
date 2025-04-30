# Student Attendance Management System

A Spring Boot application for managing student attendance with MongoDB backend.

## Prerequisites

- Java 17+
- MongoDB 6.0+
- Maven 3.6+

## Tech Stack

- Spring Boot 3.2.0
- Spring Data MongoDB
- Spring Web
- Maven

## Getting Started

### 1. Clone the repository
```bash
git clone <repository-url>
cd demo
```

### 2. Configure MongoDB
Make sure MongoDB is running on localhost:27017 or update the connection settings in `application.properties`:
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/student_db
```

### 3. Build the project
```bash
mvn clean install
```

### 4. Run the application
```bash
mvn spring-boot:run
```
The application will start on `http://localhost:8080`

## API Endpoints

### Student Management
- `GET /api/students` - Get all students
- `GET /api/students/{id}` - Get student by ID
- `POST /api/students` - Create new student
- `PUT /api/students/{id}` - Update student
- `DELETE /api/students/{id}` - Delete student

### Attendance Management
- `GET /api/attendance` - Get all attendance records
- `GET /api/attendance/{id}` - Get attendance by ID
- `POST /api/attendance` - Create attendance record
- `PUT /api/attendance/{id}` - Update attendance record
- `DELETE /api/attendance/{id}` - Delete attendance record

## Project Structure
```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── demo/
│   │               ├── controller/
│   │               ├── model/
│   │               ├── repository/
│   │               └── service/
│   └── resources/
│       └── application.properties
└── test/
    └── java/
```

## Contributing
1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License
This project is licensed under the MIT License - see the LICENSE file for details
