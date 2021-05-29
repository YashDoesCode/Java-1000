public class PomodoroTimerControl {

    private int workMinutes = 25;
    private int breakMinutes = 5;
    private int cycles = 0;

    public void completeWorkCycle() {
        cycles++;
    }

    public boolean isLongBreakDue() {
        return cycles % 4 == 0;
    }

    public int getWorkMinutes() {
        return workMinutes;
    }

    public int getBreakMinutes() {
        return breakMinutes;
    }

    public int getCompletedCycles() {
        return cycles;
    }
}
