package service;

import model.FocusSession;
import java.util.ArrayList;

public class FocusTracker {

    private ArrayList<FocusSession> sessions;

    public FocusTracker() {
        sessions = new ArrayList<>();
    }

    // Add a focus session
    public void addSession(FocusSession session) {
        sessions.add(session);
        System.out.println("Focus session added successfully.");
    }

    // Display all focus sessions
    public void viewSessions() {

        if (sessions.isEmpty()) {
            System.out.println("No focus sessions available.");
            return;
        }

        for (FocusSession session : sessions) {

            System.out.println("Session ID: " + session.getSessionId());
            System.out.println("Task ID: " + session.getTaskId());
            System.out.println("Activity: " + session.getActivity());
            System.out.println("Start Time: " + session.getStartTime());
            System.out.println("End Time: " + session.getEndTime());
            System.out.println(
                "Duration: " + session.getDuration() + " minutes"
            );

            System.out.println("----------------------------");
        }
    }

    // Calculate total focus time
    public int getTotalFocusTime() {

        int total = 0;

        for (FocusSession session : sessions) {
            total += session.getDuration();
        }

        return total;
    }

    // Display total focus time
    public void displayTotalFocusTime() {

        System.out.println(
            "Total Focus Time: "
            + getTotalFocusTime()
            + " minutes"
        );
    }

    // Return all focus sessions
    public ArrayList<FocusSession> getSessions() {
        return sessions;
    }
}
