import model.Task;
import model.FocusSession;
import service.TaskManager;
import service.FocusTracker;
import service.Analytics;
import service.ReportGenerator;
import util.Validator;
import util.DatabaseManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Initialize database
        DatabaseManager.createTables();

        Scanner scanner = new Scanner(System.in);

        TaskManager taskManager = new TaskManager();
        FocusTracker focusTracker = new FocusTracker();
        Analytics analytics = new Analytics();
        ReportGenerator reportGenerator = new ReportGenerator();

        int choice;

        do {

            System.out.println();
            System.out.println("======================================");
            System.out.println("     PERSONAL PRODUCTIVITY TRACKER");
            System.out.println("======================================");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Add Focus Session");
            System.out.println("6. View Focus Sessions");
            System.out.println("7. View Productivity Statistics");
            System.out.println("8. Generate Productivity Report");
            System.out.println("9. Exit");
            System.out.println("======================================");

            choice = readInt(scanner, "Enter your choice: ");

            switch (choice) {

                case 1:
                    addTask(scanner, taskManager);
                    break;

                case 2:
                    System.out.println();
                    System.out.println("----- All Tasks -----");
                    taskManager.viewTasks();
                    break;

                case 3:
                    updateTask(scanner, taskManager);
                    break;

                case 4:
                    deleteTask(scanner, taskManager);
                    break;

                case 5:
                    addFocusSession(
                        scanner,
                        taskManager,
                        focusTracker
                    );
                    break;

                case 6:
                    System.out.println();
                    System.out.println("----- Focus Sessions -----");
                    focusTracker.viewSessions();
                    break;

                case 7:
                    System.out.println();
                    System.out.println(
                        "----- Productivity Statistics -----"
                    );

                    analytics.displayStatistics(
                        taskManager.getTasks(),
                        focusTracker.getSessions()
                    );
                    break;

                case 8:
                    reportGenerator.generateReport(
                        taskManager.getTasks(),
                        focusTracker.getSessions()
                    );
                    break;

                case 9:
                    System.out.println();
                    System.out.println(
                        "Thank you for using Personal Productivity Tracker!"
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice. Please select 1-9."
                    );
            }

        } while (choice != 9);

        scanner.close();
    }

    // Add a new task
    private static void addTask(
            Scanner scanner,
            TaskManager taskManager) {

        System.out.println();
        System.out.println("----- Add New Task -----");

        int taskId =
            readInt(scanner, "Enter Task ID: ");

        if (!Validator.isValidTaskId(taskId)) {
            System.out.println("Invalid Task ID.");
            return;
        }

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        if (Validator.isEmpty(title)) {
            System.out.println("Title cannot be empty.");
            return;
        }

        System.out.print("Enter Description: ");
        String description = scanner.nextLine();

        System.out.print("Enter Category: ");
        String category = scanner.nextLine();

        System.out.print(
            "Enter Priority (Low/Medium/High): "
        );
        String priority = scanner.nextLine();

        if (!Validator.isValidPriority(priority)) {
            System.out.println("Invalid priority.");
            return;
        }

        System.out.print("Enter Deadline: ");
        String deadline = scanner.nextLine();

        System.out.print(
            "Enter Status (Pending/Completed): "
        );
        String status = scanner.nextLine();

        if (!Validator.isValidStatus(status)) {
            System.out.println("Invalid status.");
            return;
        }

        Task task = new Task(
            taskId,
            title,
            description,
            category,
            priority,
            deadline,
            status
        );

        taskManager.addTask(task);
    }

    // Update a task
    private static void updateTask(
            Scanner scanner,
            TaskManager taskManager) {

        System.out.println();
        System.out.println("----- Update Task -----");

        int updateId =
            readInt(scanner, "Enter Task ID to update: ");

        if (!taskManager.taskExists(updateId)) {
            System.out.println("Task not found.");
            return;
        }

        System.out.print("Enter New Title: ");
        String newTitle = scanner.nextLine();

        if (Validator.isEmpty(newTitle)) {
            System.out.println("Title cannot be empty.");
            return;
        }

        System.out.print("Enter New Description: ");
        String newDescription = scanner.nextLine();

        System.out.print("Enter New Category: ");
        String newCategory = scanner.nextLine();

        System.out.print(
            "Enter New Priority (Low/Medium/High): "
        );
        String newPriority = scanner.nextLine();

        if (!Validator.isValidPriority(newPriority)) {
            System.out.println("Invalid priority.");
            return;
        }

        System.out.print("Enter New Deadline: ");
        String newDeadline = scanner.nextLine();

        System.out.print(
            "Enter New Status (Pending/Completed): "
        );
        String newStatus = scanner.nextLine();

        if (!Validator.isValidStatus(newStatus)) {
            System.out.println("Invalid status.");
            return;
        }

        taskManager.updateTask(
            updateId,
            newTitle,
            newDescription,
            newCategory,
            newPriority,
            newDeadline,
            newStatus
        );
    }

    // Delete a task
    private static void deleteTask(
            Scanner scanner,
            TaskManager taskManager) {

        System.out.println();
        System.out.println("----- Delete Task -----");

        int deleteId =
            readInt(scanner, "Enter Task ID to delete: ");

        if (!taskManager.taskExists(deleteId)) {
            System.out.println("Task not found.");
            return;
        }

        taskManager.deleteTask(deleteId);
    }

    // Add a focus session
    private static void addFocusSession(
            Scanner scanner,
            TaskManager taskManager,
            FocusTracker focusTracker) {

        System.out.println();
        System.out.println("----- Add Focus Session -----");

        int sessionId =
            readInt(scanner, "Enter Session ID: ");

        if (sessionId <= 0) {
            System.out.println("Invalid Session ID.");
            return;
        }

        int focusTaskId =
            readInt(scanner, "Enter Task ID: ");

        if (!taskManager.taskExists(focusTaskId)) {
            System.out.println(
                "Task ID does not exist. Please add the task first."
            );
            return;
        }

        System.out.print("Enter Activity: ");
        String activity = scanner.nextLine();

        if (Validator.isEmpty(activity)) {
            System.out.println("Activity cannot be empty.");
            return;
        }

        System.out.print("Enter Start Time: ");
        String startTime = scanner.nextLine();

        System.out.print("Enter End Time: ");
        String endTime = scanner.nextLine();

        int duration =
            readInt(
                scanner,
                "Enter Duration (minutes): "
            );

        if (!Validator.isValidDuration(duration)) {
            System.out.println("Invalid duration.");
            return;
        }

        FocusSession session = new FocusSession(
            sessionId,
            focusTaskId,
            activity,
            startTime,
            endTime,
            duration
        );

        focusTracker.addSession(session);
    }

    // Safely read an integer
    private static int readInt(
            Scanner scanner,
            String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            try {

                return Integer.parseInt(input.trim());

            } catch (NumberFormatException e) {

                System.out.println(
                    "Invalid input. Please enter a number."
                );
            }
        }
    }
}
