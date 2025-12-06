# Student Management System - Java + JDBC

## Description
This is a **Menu-Driven Student Management System** built in Java using JDBC to connect to a MySQL database.  
The project allows users to **Insert, Update, Delete, Search, and Display student records**. It demonstrates basic **CRUD operations** and proper database handling in Java.

## Features
- Add new student records
- Update existing student details
- Delete student records
- Search for a student by ID
- Display all students
- Menu-driven interface for easy navigation

## Tech Stack
- Java (Core Java)
- JDBC (Java Database Connectivity)
- MySQL (Database)
- Eclipse IDE / Maven project structure

## Folder Structure
StudentManagementSystem/
│
├─ src/main/java/task5/MenuDrivenProgram.java
├─ src/main/java/com/student/StudentJDBC/DBConnection.java
├─ pom.xml
└─ target/

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/AlanKJosephDev/StudentManagementSystem-Java.git
2. Open the project in Eclipse or IntelliJ IDEA
3. Make sure MySQL is installed and running
4. Create a database student_db and a student table:
   CREATE DATABASE student_db;
   USE student_db;
   CREATE TABLE student(
    id INT PRIMARY KEY,
    name VARCHAR(50)
   );
5.Update the DB connection credentials in MenuDrivenProgram.java if needed
6.Run the program → Use the menu to manage student records

## Author
**Alan K Joseph**  
[GitHub](https://github.com/AlanKJosephDev) | [LinkedIn](https://www.linkedin.com/in/josephalank332002)


