package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    private static final String URL = "jdbc:sqlite:productivity.db";

    // Establish connection with SQLite database
    public static Connection connect() {

        try {
            Connection connection =
                    DriverManager.getConnection(URL);

            // Enable foreign key support
            try (Statement statement = connection.createStatement()) {
                statement.execute("PRAGMA foreign_keys = ON");
            }

            return connection;

        } catch (SQLException e) {

            System.out.println("Database connection failed.");
            System.out.println("Error: " + e.getMessage());

            return null;
        }
    }

    // Create database tables
    public static void createTables() {

        String taskTable = """
                CREATE TABLE IF NOT EXISTS tasks (
                    task_id INTEGER PRIMARY KEY,
                    title TEXT NOT NULL,
                    description TEXT,
                    category TEXT,
                    priority TEXT,
                    deadline TEXT,
                    status TEXT
                )
                """;

        String focusTable = """
                CREATE TABLE IF NOT EXISTS focus_sessions (
                    session_id INTEGER PRIMARY KEY,
                    task_id INTEGER,
                    activity TEXT,
                    start_time TEXT,
                    end_time TEXT,
                    duration INTEGER,
                    FOREIGN KEY (task_id) REFERENCES tasks(task_id)
                )
                """;

        Connection connection = connect();

        if (connection == null) {
            System.out.println(
                "Database tables could not be created."
            );
            return;
        }

        try (connection;
             Statement statement = connection.createStatement()) {

            statement.execute(taskTable);
            statement.execute(focusTable);

            System.out.println(
                "Database tables created successfully."
            );

        } catch (SQLException e) {

            System.out.println(
                "Error creating database tables."
            );

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }
}
