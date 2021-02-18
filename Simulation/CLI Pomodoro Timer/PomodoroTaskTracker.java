import java.util.*;

public class PomodoroTaskTracker {

    private final int workMinutes;
    private final int breakMinutes;
    private int completedSessions = 0;

    public PomodoroTaskTracker(int workMinutes, int breakMinutes) {
        this.workMinutes = workMinutes;
        this.breakMinutes = breakMinutes;
    }

    public void startSession(String taskName) {
        System.out.println("Starting Pomodoro for task: " + taskName);
        completedSessions++;
    }

    public int getCompletedSessions() {
        return completedSessions;
    }

    public int getTotalWorkMinutes() {
        return completedSessions * workMinutes;
    }
}
