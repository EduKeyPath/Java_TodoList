package Java_TodoList.src.com.todo.ui;

import java.util.List;
import java.util.Scanner;

import Java_TodoList.src.com.todo.dao.TodoDAO;
import Java_TodoList.src.com.todo.model.Todo;

public class TodoApp {
    public static void main(String[] args){
        TodoDAO dao = new TodoDAO();
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("TODO LIST: ");
                System.out.print("1.View ");
                System.out.print("2.Add ");
                System.out.print("3.Edit ");
                System.out.print("4.Remove ");
                System.out.print("5.Close ");
                System.out.println("");
                System.out.println("Enter your choice with type the No only");
                int userChoice = Integer.parseInt(sc.nextLine());

                try{
                    switch (userChoice) {
                        case 1:
                            List<Todo> todos = dao.getAllTodos();
                            todos.forEach(System.out::println);   // Call System.out.println() for each element in the list."
                            /* OR we can do */
                            // for(Todo t : todos){
                            //     System.out.println(t);
                            // }
                            break;
                        case 2:
                            System.out.println("Title");
                            String title = sc.nextLine();
   
                            System.out.println("Description");
                            String desc = sc.nextLine();
   
                            dao.addTodo(new Todo(title, desc, "Pending"));
   
                            break;
                        case 3:
                            System.out.println("Enter ID to edit the Todo item");
                            int id = sc.nextInt(); sc.nextLine();
   
                            System.out.println("New Title");
                            title = sc.nextLine();
   
                            System.out.println("New Description");
                            desc = sc.nextLine();
   
                            System.out.println("Status (Pending/Done): ");
                            String status = sc.nextLine();
   
                            dao.updateTodo(new Todo(id, title, desc, status));
   
                            break;
                        case 4:
                            System.out.println("Enter ID to remove the Todo item");
                            id = sc.nextInt(); sc.nextLine();
                            dao.deleteTodo(id);
                            break;
                        case 5:
                            System.out.println("Todo list closed");
                            break;
                        default:
                            System.out.println("Invalid input");
                            break;
                    }
                }catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
