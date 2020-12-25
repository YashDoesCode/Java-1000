public class TrafficIntersectionSim {

    public enum SignalState { NORTH_SOUTH_GREEN, NORTH_SOUTH_YELLOW, EAST_WEST_GREEN, EAST_WEST_YELLOW }

    private SignalState state = SignalState.NORTH_SOUTH_GREEN;

    public void advanceSignal() {
        switch (state) {
            case NORTH_SOUTH_GREEN:
                state = SignalState.NORTH_SOUTH_YELLOW;
                break;
            case NORTH_SOUTH_YELLOW:
                state = SignalState.EAST_WEST_GREEN;
                break;
            case EAST_WEST_GREEN:
                state = SignalState.EAST_WEST_YELLOW;
                break;
            case EAST_WEST_YELLOW:
                state = SignalState.NORTH_SOUTH_GREEN;
                break;
        }
    }

    public SignalState getState() {
        return state;
    }
}
