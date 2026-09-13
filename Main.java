import model.Task;
import model.FocusSession;
import service.TaskManager;
import service.FocusTracker;
import service.Analytics;
import service.ReportGenerator;
import util.Validator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

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

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.println();
                    System.out.println("----- Add New Task -----");

                    System.out.print("Enter Task ID: ");
                    int taskId = scanner.nextInt();
                    scanner.nextLine();

                    if (!Validator.isValidTaskId(taskId)) {
                        System.out.println("Invalid Task ID.");
                        break;
                    }

                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();

                    if (Validator.isEmpty(title)) {
                        System.out.println("Title cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Description: ");
                    String description = scanner.nextLine();

                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();

                    System.out.print("Enter Priority (Low/Medium/High): ");
                    String priority = scanner.nextLine();

                    if (!Validator.isValidPriority(priority)) {
                        System.out.println("Invalid priority.");
                        break;
                    }

                    System.out.print("Enter Deadline: ");
                    String deadline = scanner.nextLine();

                    System.out.print("Enter Status (Pending/Completed): ");
                    String status = scanner.nextLine();

                    if (!Validator.isValidStatus(status)) {
                        System.out.println("Invalid status.");
                        break;
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
                    break;

                case 2:

                    System.out.println();
                    System.out.println("----- All Tasks -----");

                    taskManager.viewTasks();
                    break;

                case 3:

                    System.out.println();
                    System.out.println("----- Update Task -----");

                    System.out.print("Enter Task ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Title: ");
                    String newTitle = scanner.nextLine();

                    System.out.print("Enter New Description: ");
                    String newDescription = scanner.nextLine();

                    System.out.print("Enter New Category: ");
                    String newCategory = scanner.nextLine();

                    System.out.print("Enter New Priority (Low/Medium/High): ");
                    String newPriority = scanner.nextLine();

                    if (!Validator.isValidPriority(newPriority)) {
                        System.out.println("Invalid priority.");
                        break;
                    }

                    System.out.print("Enter New Deadline: ");
                    String newDeadline = scanner.nextLine();

                    System.out.print("Enter New Status (Pending/Completed): ");
                    String newStatus = scanner.nextLine();

                    if (!Validator.isValidStatus(newStatus)) {
                        System.out.println("Invalid status.");
                        break;
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

                    break;

                case 4:

                    System.out.println();
                    System.out.println("----- Delete Task -----");

                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    taskManager.deleteTask(deleteId);
                    break;

                case 5:

                    System.out.println();
                    System.out.println("----- Add Focus Session -----");

                    System.out.print("Enter Session ID: ");
                    int sessionId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Task ID: ");
                    int focusTaskId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Activity: ");
                    String activity = scanner.nextLine();

                    System.out.print("Enter Start Time: ");
                    String startTime = scanner.nextLine();

                    System.out.print("Enter End Time: ");
                    String endTime = scanner.nextLine();

                    System.out.print("Enter Duration (minutes): ");
                    int duration = scanner.nextInt();
                    scanner.nextLine();

                    if (!Validator.isValidDuration(duration)) {
                        System.out.println("Invalid duration.");
                        break;
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
                    break;

                case 6:

                    System.out.println();
                    System.out.println("----- Focus Sessions -----");

                    focusTracker.viewSessions();
                    break;

                case 7:

                    System.out.println();
                    System.out.println("----- Productivity Statistics -----");

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
                    System.out.println("Thank you for using Personal Productivity Tracker!");
                    break;

                default:

                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 9);

        scanner.close();
    }
}
