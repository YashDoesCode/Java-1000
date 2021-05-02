import java.util.*;
public class ParkingLotAllocator {

    public enum SpotType {
        COMPACT, LARGE, EV;
    }

    private Map<SpotType, Integer> availableSpots = new HashMap<>();

    public ParkingLotAllocator(int compact, int large, int ev) {
        availableSpots.put(SpotType.COMPACT, compact);
        availableSpots.put(SpotType.LARGE, large);
        availableSpots.put(SpotType.EV, ev);
    }

    public boolean parkVehicle(SpotType type) {
        int spots = availableSpots.getOrDefault(type, 0);
        if (spots > 0) {
            availableSpots.put(type, spots - 1);
            return true;
        }
        return false;
    }

    public void leaveVehicle(SpotType type) {
        availableSpots.put(type, availableSpots.getOrDefault(type, 0) + 1);
    }
}
