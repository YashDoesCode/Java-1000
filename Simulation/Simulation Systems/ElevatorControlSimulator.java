public class ElevatorControlSimulator {

    public enum Direction {
        UP, DOWN, IDLE;
    }

    private int currentFloor = 1;
    private Direction direction = Direction.IDLE;

    public void moveToFloor(int targetFloor) {
        if (targetFloor > currentFloor) direction = Direction.UP;
        else if (targetFloor < currentFloor) direction = Direction.DOWN;
        else direction = Direction.IDLE;
        currentFloor = targetFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }
}
