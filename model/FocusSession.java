package model;

public class FocusSession {

    private int sessionId;
    private int taskId;
    private String activity;
    private String startTime;
    private String endTime;
    private int duration;

    public FocusSession(int sessionId, int taskId, String activity,
                        String startTime, String endTime, int duration) {

        this.sessionId = sessionId;
        this.taskId = taskId;
        this.activity = activity;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
    }

    public int getSessionId() {
        return sessionId;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
