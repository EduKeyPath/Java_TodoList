package Java_TodoList.src.com.todo.dao;

import Java_TodoList.src.com.todo.db.DBConnection;
import Java_TodoList.src.com.todo.model.Todo;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {

    // For add item in the ToDo list and store in DB
    public void addTodo(Todo todo) throws SQLException {
        String sql = "INSERT INTO todos (title, description, status) VALUES (?, ?, ?)";
        try(Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);){
            stmt.setString(1, todo.getTitle());
            stmt.setString(2, todo.getDescription());
            stmt.setString(3, todo.getStatus());
            stmt.executeUpdate();
        }
    }

    // For get all item from the ToDo list DB
    public List<Todo> getAllTodos() throws SQLException {
        List<Todo> todos = new ArrayList<>();
        String sql = "SELECT * FROM todos";
        try(Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);){
            while (rs.next()) {
                todos.add(new Todo(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("status")
                ));
            }
        }
        return todos;
    }

    // For update each item of the ToDo list and update on the DB
    public void updateTodo(Todo todo) throws SQLException {
        String sql = "UPDATE todos SET title = ?, description = ?, status = ? WHERE id = ?";
        try(Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);){
            stmt.setString(1, todo.getTitle());
            stmt.setString(2, todo.getDescription());
            stmt.setString(3, todo.getStatus());
            stmt.setInt(4, todo.getId());
            stmt.executeUpdate();
        }
    }

    // For Delete the todo item from the list and update in the DB
    public void deleteTodo(int id) throws SQLException{
        String sql = "DELETE FROM todos WHERE id = ?";
        try(Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
