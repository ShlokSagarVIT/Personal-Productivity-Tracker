package service;

import model.Task;
import model.FocusSession;
import java.util.ArrayList;

public class ReportGenerator {

    // Generate a productivity report
    public void generateReport(ArrayList<Task> tasks,
                               ArrayList<FocusSession> sessions) {

        int totalTasks = tasks.size();
        int completedTasks = 0;
        int pendingTasks = 0;
        int totalFocusTime = 0;

        for (Task task : tasks) {
            if (task.getStatus().equalsIgnoreCase("Completed")) {
                completedTasks++;
            } else {
                pendingTasks++;
            }
        }

        for (FocusSession session : sessions) {
            totalFocusTime += session.getDuration();
        }

        double completionRate = 0;

        if (totalTasks > 0) {
            completionRate = ((double) completedTasks / totalTasks) * 100;
        }

        System.out.println();
        System.out.println("======================================");
        System.out.println("       PERSONAL PRODUCTIVITY REPORT");
        System.out.println("======================================");

        System.out.println("Total Tasks       : " + totalTasks);
        System.out.println("Completed Tasks   : " + completedTasks);
        System.out.println("Pending Tasks     : " + pendingTasks);

        System.out.println(
            "Completion Rate   : "
            + String.format("%.2f", completionRate) + "%"
        );

        System.out.println(
            "Total Focus Time  : "
            + totalFocusTime + " minutes"
        );

        System.out.println("======================================");
    }
}
