package service;

import model.Task;
import java.util.ArrayList;

public class TaskManager {

    private ArrayList<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    // Add a new task
    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added successfully.");
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
    public void updateTask(int taskId, String newTitle, String newDescription,
                           String newCategory, String newPriority,
                           String newDeadline, String newStatus) {

        for (Task task : tasks) {

            if (task.getTaskId() == taskId) {

                task.setTitle(newTitle);
                task.setDescription(newDescription);
                task.setCategory(newCategory);
                task.setPriority(newPriority);
                task.setDeadline(newDeadline);
                task.setStatus(newStatus);

                System.out.println("Task updated successfully.");
                return;
            }
        }

        System.out.println("Task not found.");
    }

    // Delete a task
    public void deleteTask(int taskId) {

        boolean removed = tasks.removeIf(
            task -> task.getTaskId() == taskId
        );

        if (removed) {
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }

    // Return all tasks
    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
