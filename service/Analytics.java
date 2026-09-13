package service;

import model.Task;
import model.FocusSession;
import java.util.ArrayList;

public class Analytics {

    // Calculate task completion rate
    public double calculateCompletionRate(ArrayList<Task> tasks) {

        if (tasks.isEmpty()) {
            return 0;
        }

        int completedTasks = 0;

        for (Task task : tasks) {
            if (task.getStatus().equalsIgnoreCase("Completed")) {
                completedTasks++;
            }
        }

        return ((double) completedTasks / tasks.size()) * 100;
    }

    // Calculate total focus time
    public int calculateTotalFocusTime(ArrayList<FocusSession> sessions) {

        int totalTime = 0;

        for (FocusSession session : sessions) {
            totalTime += session.getDuration();
        }

        return totalTime;
    }

    // Display productivity statistics
    public void displayStatistics(ArrayList<Task> tasks,
                                  ArrayList<FocusSession> sessions) {

        int totalTasks = tasks.size();
        int totalFocusTime = calculateTotalFocusTime(sessions);
        double completionRate = calculateCompletionRate(tasks);

        System.out.println("===== Productivity Statistics =====");
        System.out.println("Total Tasks: " + totalTasks);
        System.out.println("Completed Task Rate: "
                           + String.format("%.2f", completionRate) + "%");
        System.out.println("Total Focus Time: "
                           + totalFocusTime + " minutes");
        System.out.println("===================================");
    }
}
