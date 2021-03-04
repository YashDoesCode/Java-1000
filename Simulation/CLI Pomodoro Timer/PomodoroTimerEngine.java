public class PomodoroTimerEngine {

    private final int sessionDurationMinutes;

    public PomodoroTimerEngine(int minutes) {
        this.sessionDurationMinutes = minutes;
    }

    public int getSessionSeconds() {
        return sessionDurationMinutes * 60;
    }
}
