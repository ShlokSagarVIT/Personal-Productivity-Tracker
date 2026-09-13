package service;

import model.Task;
import util.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaskManager {

    private ArrayList<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
        loadTasksFromDatabase();
    }

    // Add a new task
    public void addTask(Task task) {

        String sql = """
                INSERT INTO tasks
                (task_id, title, description, category, priority, deadline, status)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection connection = DatabaseManager.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, task.getTaskId());
            statement.setString(2, task.getTitle());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getCategory());
            statement.setString(5, task.getPriority());
            statement.setString(6, task.getDeadline());
            statement.setString(7, task.getStatus());

            statement.executeUpdate();

            tasks.add(task);

            System.out.println("Task added successfully.");

        } catch (SQLException e) {
            System.out.println("Error adding task.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Display all tasks
    public void viewTasks() {

        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        for (Task task : tasks) {

            System.out.println("Task ID: " + task.getTaskId());
            System.out.println("Title: " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Category: " + task.getCategory());
            System.out.println("Priority: " + task.getPriority());
            System.out.println("Deadline: " + task.getDeadline());
            System.out.println("Status: " + task.getStatus());
            System.out.println("----------------------------");
        }
    }

    // Update an existing task
    public void updateTask(
            int taskId,
            String newTitle,
            String newDescription,
            String newCategory,
            String newPriority,
            String newDeadline,
            String newStatus) {

        String sql = """
                UPDATE tasks
                SET title = ?,
                    description = ?,
                    category = ?,
                    priority = ?,
                    deadline = ?,
                    status = ?
                WHERE task_id = ?
                """;

        try (Connection connection = DatabaseManager.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newTitle);
            statement.setString(2, newDescription);
            statement.setString(3, newCategory);
            statement.setString(4, newPriority);
            statement.setString(5, newDeadline);
            statement.setString(6, newStatus);
            statement.setInt(7, taskId);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {

                for (Task task : tasks) {

                    if (task.getTaskId() == taskId) {

                        task.setTitle(newTitle);
                        task.setDescription(newDescription);
                        task.setCategory(newCategory);
                        task.setPriority(newPriority);
                        task.setDeadline(newDeadline);
                        task.setStatus(newStatus);

                        break;
                    }
                }

                System.out.println("Task updated successfully.");

            } else {
                System.out.println("Task not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error updating task.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Delete a task
    public void deleteTask(int taskId) {

        String sql = "DELETE FROM tasks WHERE task_id = ?";

        try (Connection connection = DatabaseManager.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, taskId);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {

                tasks.removeIf(
                    task -> task.getTaskId() == taskId
                );

                System.out.println("Task deleted successfully.");

            } else {
                System.out.println("Task not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting task.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Load existing tasks from database
    private void loadTasksFromDatabase() {

        String sql = "SELECT * FROM tasks";

        try (Connection connection = DatabaseManager.connect();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Task task = new Task(
                    resultSet.getInt("task_id"),
                    resultSet.getString("title"),
                    resultSet.getString("description"),
                    resultSet.getString("category"),
                    resultSet.getString("priority"),
                    resultSet.getString("deadline"),
                    resultSet.getString("status")
                );

                tasks.add(task);
            }

        } catch (SQLException e) {
            System.out.println("Error loading tasks.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Return all tasks
    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
