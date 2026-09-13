package service;

import model.Task;
import java.util.ArrayList;

public class TaskManager {

    private ArrayList<Task> tasks;

public TaskManager() {
    tasks = new ArrayList<>();
}

public void addTask(Task task) {
    tasks.add(task);
}
public void viewTasks() {
    if (tasks.isEmpty()) {
        System.out.println("No tasks available.");
        return;
    }

    for (Task task : tasks) {
        System.out.println("Task ID: " + task.getTaskId());
        System.out.println("Title: " + task.getTitle());
        System.out.println("Category: " + task.getCategory());
        System.out.println("Priority: " + task.getPriority());
        System.out.println("Deadline: " + task.getDeadline());
        System.out.println("Status: " + task.getStatus());
        System.out.println("----------------------------");
    }
}
}
