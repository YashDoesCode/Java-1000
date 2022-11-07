public class CircuitBreakerControl {

    public enum State {
        CLOSED, OPEN, HALF_OPEN;
    }

    private State state = State.CLOSED;
    private int failureThreshold = 3;
    private int failureCount = 0;
    private long openStateTimestamp = 0;
    private long resetTimeoutMs = 5000;

    public synchronized boolean allowRequest() {
        if (state == State.OPEN) {
            if (System.currentTimeMillis() - openStateTimestamp > resetTimeoutMs) {
                state = State.HALF_OPEN;
                return true;
            }
            return false;
        }
        return true;
    }

    public synchronized void recordSuccess() {
        failureCount = 0;
        state = State.CLOSED;
    }

    public synchronized void recordFailure() {
        failureCount++;
        if (failureCount >= failureThreshold) {
            state = State.OPEN;
            openStateTimestamp = System.currentTimeMillis();
        }
    }

    public State getState() {
        return state;
    }
}
