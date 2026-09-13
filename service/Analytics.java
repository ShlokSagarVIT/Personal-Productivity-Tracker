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
    public int calculateTotalFocusTime(
            ArrayList<FocusSession> sessions) {

        int totalTime = 0;

        for (FocusSession session : sessions) {
            totalTime += session.getDuration();
        }

        return totalTime;
    }

    // Calculate number of completed tasks
    public int getCompletedTasks(ArrayList<Task> tasks) {

        int completed = 0;

        for (Task task : tasks) {

            if (task.getStatus().equalsIgnoreCase("Completed")) {
                completed++;
            }
        }

        return completed;
    }

    // Calculate number of pending tasks
    public int getPendingTasks(ArrayList<Task> tasks) {

        int pending = 0;

        for (Task task : tasks) {

            if (task.getStatus().equalsIgnoreCase("Pending")) {
                pending++;
            }
        }

        return pending;
    }

    // Calculate productivity score
    public double calculateProductivityScore(
            ArrayList<Task> tasks,
            ArrayList<FocusSession> sessions) {

        double completionRate = calculateCompletionRate(tasks);
        int focusTime = calculateTotalFocusTime(sessions);

        /*
         * Productivity score:
         * 70% based on task completion
         * 30% based on focus time
         *
         * Maximum focus contribution is reached
         * at 120 minutes of focus time.
         */

        double focusScore = Math.min(
            (focusTime / 120.0) * 100,
            100
        );

        return (completionRate * 0.70)
                + (focusScore * 0.30);
    }

    // Display productivity statistics
    public void displayStatistics(
            ArrayList<Task> tasks,
            ArrayList<FocusSession> sessions) {

        int totalTasks = tasks.size();
        int completedTasks = getCompletedTasks(tasks);
        int pendingTasks = getPendingTasks(tasks);

        int totalFocusTime = calculateTotalFocusTime(sessions);

        double completionRate =
            calculateCompletionRate(tasks);

        double productivityScore =
            calculateProductivityScore(tasks, sessions);

        System.out.println();
        System.out.println("======================================");
        System.out.println("       PRODUCTIVITY STATISTICS");
        System.out.println("======================================");

        System.out.println("Total Tasks       : " + totalTasks);
        System.out.println("Completed Tasks   : " + completedTasks);
        System.out.println("Pending Tasks     : " + pendingTasks);

        System.out.println(
            "Completion Rate   : "
            + String.format("%.2f", completionRate)
            + "%"
        );

        System.out.println(
            "Total Focus Time  : "
            + totalFocusTime
            + " minutes"
        );

        System.out.println(
            "Productivity Score: "
            + String.format("%.2f", productivityScore)
            + "/100"
        );

        System.out.println("======================================");
    }
}
