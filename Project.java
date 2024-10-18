import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<String> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("To-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public void deleteTask(int index) {
        if (index >= 1 && index <= tasks.size()) {
            System.out.println("Task deleted: " + tasks.get(index - 1));
            tasks.remove(index - 1);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the To-Do List App!");
        while (true) {
            System.out.println("\nEnter a command (add, view, delete, exit):");
            command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "add":
                    System.out.println("Enter a task:");
                    String task = scanner.nextLine();
                    toDoList.addTask(task);
                    break;
                case "view":
                    toDoList.viewTasks();
                    break;
                case "delete":
                    toDoList.viewTasks();
                    System.out.println("Enter the task number to delete:");
                    int taskNumber = scanner.nextInt();
                    scanner.nextLine(); // Clear the buffer
                    toDoList.deleteTask(taskNumber);
                    break;
                case "exit":
                    System.out.println("Exiting the app. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }
}
