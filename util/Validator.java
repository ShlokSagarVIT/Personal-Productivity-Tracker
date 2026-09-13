package util;

public class Validator {

    // Check whether a text value is empty
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    // Validate task priority
    public static boolean isValidPriority(String priority) {

        if (isEmpty(priority)) {
            return false;
        }

        return priority.equalsIgnoreCase("Low")
                || priority.equalsIgnoreCase("Medium")
                || priority.equalsIgnoreCase("High");
    }

    // Validate task status
    public static boolean isValidStatus(String status) {

        if (isEmpty(status)) {
            return false;
        }

        return status.equalsIgnoreCase("Pending")
                || status.equalsIgnoreCase("Completed");
    }

    // Validate task ID
    public static boolean isValidTaskId(int taskId) {
        return taskId > 0;
    }

    // Validate duration
    public static boolean isValidDuration(int duration) {
        return duration >= 0;
    }
}
