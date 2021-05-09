public class TrafficLightController {

    public enum State {
        RED, GREEN, YELLOW;
    }

    private State currentState = State.RED;

    public void advance() {
        switch (currentState) {
            case RED -> currentState = State.GREEN;
            case GREEN -> currentState = State.YELLOW;
            case YELLOW -> currentState = State.RED;
        }
    }

    public State getCurrentState() {
        return currentState;
    }
}
