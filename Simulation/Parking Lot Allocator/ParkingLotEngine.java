import java.util.*;

public class ParkingLotEngine {

    private final Set<Integer> occupiedSpots = new HashSet<>();

    public boolean park(int spotId) {
        return occupiedSpots.add(spotId);
    }

    public boolean leave(int spotId) {
        return occupiedSpots.remove(spotId);
    }
}
