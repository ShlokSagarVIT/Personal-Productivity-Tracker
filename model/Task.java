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

    public int getTaskId() {
        return taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
