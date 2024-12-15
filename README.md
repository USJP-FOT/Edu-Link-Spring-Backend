# EduLink Project

## Overview
EduLink is a web-based application developed using Spring Boot with a layered architecture. The application enables the management of students, attendance, lockers, and announcements, offering real-time attendance updates via WebSocket.

## Features
- **Student Management**: Add, retrieve, and delete student records.
- **Attendance Tracking**: Record attendance and view attendance records for students.
- **Locker Management**: Manage locker statuses and assignments.
- **Announcements**: Create, view, and delete announcements.
- **Real-Time Updates**: Attendance updates are broadcast in real-time using WebSocket.

## Technologies Used
- **Backend**: Spring Boot, Java
- **WebSocket**: Real-time communication
- **Persistence**: Hibernate, JPA, MySQL
- **Object Mapping**: ModelMapper
- **Dependency Management**: Maven

## Layered Architecture

### 1. **Controller Layer**
Responsible for handling HTTP requests and WebSocket connections.
- `AnnouncementController`
- `AttendanceController`
- `LockerController`
- `StudentController`

### 2. **Service Layer**
Contains business logic and communicates between the controller and repository layers.

### 3. **Repository Layer**
Responsible for database interactions using Spring Data JPA.

### 4. **DTOs and Entities**
- **DTOs**: Used for data transfer between layers.
  - `Attendance`, `ClassRoom`, `Locker`, `Student`
- **Entities**: Represent database tables.
  - `AnnouncementEntity`, `AttendanceEntity`, `LockerEntity`, `StudentEntity`

## API Endpoints

### **Announcements**
| Method | Endpoint         | Description          |
|--------|------------------|----------------------|
| POST   | `/announcement/add`      | Add a new announcement |
| GET    | `/announcement/get-all`  | Get all announcements  |
| DELETE | `/announcement/delete`   | Delete an announcement by ID |

**Sample URL:** `http://localhost:8080/announcement`

### **Attendance**
| Method | Endpoint         | Description          |
|--------|------------------|----------------------|
| POST   | `/attendance/mark`       | Mark attendance for a student |
| GET    | `/attendance/all`        | Get all attendance records |

**Sample URL:** `http://localhost:8080/attendance`

### **Lockers**
| Method | Endpoint         | Description          |
|--------|------------------|----------------------|
| GET    | `/locker/all`           | Get all locker details |
| POST   | `/locker/add`           | Add a new locker       |
| DELETE | `/locker/delete`        | Delete a locker by ID  |
| PATCH  | `/locker/set-status`    | Update locker status   |
| GET    | `/locker/get-status`    | Get the status of a locker by ID |

**Sample URL:** `http://localhost:8080/locker`

### **Students**
| Method | Endpoint         | Description          |
|--------|------------------|----------------------|
| POST   | `/student/add`         | Add a new student     |
| GET    | `/student/all`         | Get all student records |
| DELETE | `/student/delete`      | Delete a student by ID |

**Sample URL:** `http://localhost:8080/student`

## Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd edulink
   ```

2. **Configure the Database**
   - Update the `application.properties` file with your MySQL database credentials.

3. **Build and Run the Application**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Access the Application**
   - The application will be available at `http://localhost:8080`.

5. **WebSocket Configuration**
   - WebSocket endpoint: `/websocket/attendance`

## Future Enhancements
- Integration with a frontend framework for a seamless user interface.
- Advanced reporting features for attendance and announcements.
- Role-based access control.

## Contribution
Feel free to fork the repository and submit pull requests for any enhancements or bug fixes.

## License
This project is licensed under the [MIT License](LICENSE).
