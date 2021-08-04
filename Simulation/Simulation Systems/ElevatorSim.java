import java.util.*;

public class ElevatorSim {

    public enum Direction { UP, DOWN, IDLE }

    private int currentFloor = 0;
    private Direction direction = Direction.IDLE;
    private final TreeSet<Integer> upRequests = new TreeSet<>();
    private final TreeSet<Integer> downRequests = new TreeSet<>(Collections.reverseOrder());

    public void requestFloor(int floor) {
        if (floor > currentFloor) upRequests.add(floor);
        else if (floor < currentFloor) downRequests.add(floor);
    }

    public void step() {
        if (direction == Direction.UP || direction == Direction.IDLE) {
            if (!upRequests.isEmpty()) {
                direction = Direction.UP;
                currentFloor = upRequests.pollFirst();
            } else if (!downRequests.isEmpty()) {
                direction = Direction.DOWN;
                currentFloor = downRequests.pollFirst();
            } else {
                direction = Direction.IDLE;
            }
        } else if (direction == Direction.DOWN) {
            if (!downRequests.isEmpty()) {
                currentFloor = downRequests.pollFirst();
            } else if (!upRequests.isEmpty()) {
                direction = Direction.UP;
                currentFloor = upRequests.pollFirst();
            } else {
                direction = Direction.IDLE;
            }
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
}
