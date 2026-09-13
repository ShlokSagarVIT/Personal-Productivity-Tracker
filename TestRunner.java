import model.Task;
import model.FocusSession;
import service.Analytics;
import util.Validator;

import java.util.ArrayList;

public class TestRunner {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("     PERSONAL PRODUCTIVITY TRACKER");
        System.out.println("            TEST RUNNER");
        System.out.println("======================================");

        testValidPriority();
        testInvalidPriority();

        testValidStatus();
        testInvalidStatus();

        testValidTaskId();
        testInvalidTaskId();

        testValidDuration();
        testInvalidDuration();

        testEmptyText();

        testCompletionRate();
        testProductivityScore();

        System.out.println();
        System.out.println("======================================");
        System.out.println("           TEST SUMMARY");
        System.out.println("======================================");
        System.out.println("Tests Passed : " + passed);
        System.out.println("Tests Failed : " + failed);
        System.out.println("Total Tests  : " + (passed + failed));
        System.out.println("======================================");

        if (failed == 0) {
            System.out.println("All tests passed successfully.");
        } else {
            System.out.println("Some tests failed.");
        }
    }

    // Test valid priority
    private static void testValidPriority() {

        boolean result = Validator.isValidPriority("High");

        check(
            "Valid Priority",
            result == true
        );
    }

    // Test invalid priority
    private static void testInvalidPriority() {

        boolean result = Validator.isValidPriority("Urgent");

        check(
            "Invalid Priority",
            result == false
        );
    }

    // Test valid status
    private static void testValidStatus() {

        boolean result = Validator.isValidStatus("Completed");

        check(
            "Valid Status",
            result == true
        );
    }

    // Test invalid status
    private static void testInvalidStatus() {

        boolean result = Validator.isValidStatus("Finished");

        check(
            "Invalid Status",
            result == false
        );
    }

    // Test valid task ID
    private static void testValidTaskId() {

        boolean result = Validator.isValidTaskId(1);

        check(
            "Valid Task ID",
            result == true
        );
    }

    // Test invalid task ID
    private static void testInvalidTaskId() {

        boolean result = Validator.isValidTaskId(0);

        check(
            "Invalid Task ID",
            result == false
        );
    }

    // Test valid duration
    private static void testValidDuration() {

        boolean result = Validator.isValidDuration(60);

        check(
            "Valid Duration",
            result == true
        );
    }

    // Test invalid duration
    private static void testInvalidDuration() {

        boolean result = Validator.isValidDuration(-10);

        check(
            "Invalid Duration",
            result == false
        );
    }

    // Test empty text
    private static void testEmptyText() {

        boolean result = Validator.isEmpty("");

        check(
            "Empty Text Validation",
            result == true
        );
    }

    // Test completion rate
    private static void testCompletionRate() {

        ArrayList<Task> tasks = new ArrayList<>();

        tasks.add(
            new Task(
                1,
                "Study Java",
                "Complete Java practice",
                "Study",
                "High",
                "2026-09-15",
                "Completed"
            )
        );

        tasks.add(
            new Task(
                2,
                "Read Book",
                "Read 20 pages",
                "Personal",
                "Medium",
                "2026-09-16",
                "Pending"
            )
        );

        Analytics analytics = new Analytics();

        double result =
            analytics.calculateCompletionRate(tasks);

        check(
            "Completion Rate",
            result == 50.0
        );
    }

    // Test productivity score
    private static void testProductivityScore() {

        ArrayList<Task> tasks = new ArrayList<>();
        ArrayList<FocusSession> sessions = new ArrayList<>();

        tasks.add(
            new Task(
                1,
                "Study Java",
                "Complete Java practice",
                "Study",
                "High",
                "2026-09-15",
                "Completed"
            )
        );

        tasks.add(
            new Task(
                2,
                "Read Book",
                "Read 20 pages",
                "Personal",
                "Medium",
                "2026-09-16",
                "Pending"
            )
        );

        sessions.add(
            new FocusSession(
                1,
                1,
                "Java Practice",
                "10:00",
                "11:00",
                60
            )
        );

        Analytics analytics = new Analytics();

        double result =
            analytics.calculateProductivityScore(
                tasks,
                sessions
            );

        /*
         * Completion Rate = 50%
         * Focus Score = 50%
         *
         * Productivity Score =
         * (50 × 0.70) + (50 × 0.30)
         * = 50
         */

        check(
            "Productivity Score",
            result == 50.0
        );
    }

    // Common test checking method
    private static void check(
            String testName,
            boolean condition) {

        if (condition) {

            System.out.println(
                "[PASS] " + testName
            );

            passed++;

        } else {

            System.out.println(
                "[FAIL] " + testName
            );

            failed++;
        }
    }
}
