package model;

public class Task {
     private int taskId;
    private String title;
    private String description;
    private String category;
    private String priority;
    private String deadline;
    private String status;


public Task(int taskId, String title, String description,
            String category, String priority, String deadline,
            String status) {

    this.taskId = taskId;
    this.title = title;
    this.description = description;
    this.category = category;
    this.priority = priority;
    this.deadline = deadline;
    this.status = status;
}

}
