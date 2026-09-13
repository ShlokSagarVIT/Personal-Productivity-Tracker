package service;

import model.FocusSession;
import util.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FocusTracker {

    private ArrayList<FocusSession> sessions;

    public FocusTracker() {
        sessions = new ArrayList<>();
        loadSessionsFromDatabase();
    }

    // Add a focus session
    public void addSession(FocusSession session) {

        String sql = """
                INSERT INTO focus_sessions
                (session_id, task_id, activity, start_time, end_time, duration)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (Connection connection = DatabaseManager.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, session.getSessionId());
            statement.setInt(2, session.getTaskId());
            statement.setString(3, session.getActivity());
            statement.setString(4, session.getStartTime());
            statement.setString(5, session.getEndTime());
            statement.setInt(6, session.getDuration());

            statement.executeUpdate();

            sessions.add(session);

            System.out.println("Focus session added successfully.");

        } catch (SQLException e) {
            System.out.println("Error adding focus session.");
            System.out.println("Error: " + e.getMessage());
        }
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

    // Load existing sessions from database
    private void loadSessionsFromDatabase() {

        String sql = "SELECT * FROM focus_sessions";

        try (Connection connection = DatabaseManager.connect();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                FocusSession session = new FocusSession(
                    resultSet.getInt("session_id"),
                    resultSet.getInt("task_id"),
                    resultSet.getString("activity"),
                    resultSet.getString("start_time"),
                    resultSet.getString("end_time"),
                    resultSet.getInt("duration")
                );

                sessions.add(session);
            }

        } catch (SQLException e) {
            System.out.println("Error loading focus sessions.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Return all focus sessions
    public ArrayList<FocusSession> getSessions() {
        return sessions;
    }
}
