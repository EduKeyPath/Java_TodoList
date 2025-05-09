# Java Todo List App with MySQL
A simple "console-based Todo List application" built using "Java" and "MySQL".  
Users can create, view, update, and delete todo items with persistent storage using a MySQL database.

## Setup Instructions (I used)

### 1. Requirements
- Java version : 17.0.12
- MySQL Server (XAMPP) : 8.0.28
- MySQL JDBC Driver (`mysql-connector-java-8.0.28.jar`)

### 2. Database Setup
CREATE DATABASE todo_app;

USE todo_app;
CREATE TABLE todos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(50) DEFAULT 'Pending'
);

### 3. Configure DB Connection
- String url = "jdbc:mysql://localhost:3306/todo_app";
- String user = "your_mysql_username";
- String password = "your_mysql_password";

### 4. Compile
javac -cp "lib/mysql-connector-j.jar" -d out $(find src -name "*.java")

### 5. Run
java -cp "out:lib/mysql-connector-j.jar" Java_TodoList.src.com.todo.ui.TodoApp


## Features
- Add new todo item
- List all todo items
- Edit todo (title, description, status)
- Delete todo by ID
- All data is persisted in MySQL

# Author
Banti Shaw - Created for learning purposes.

