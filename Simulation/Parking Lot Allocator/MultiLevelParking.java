import java.util.*;

public class MultiLevelParking {

    public enum VehicleType { COMPACT, LARGE, MOTORCYCLE }

    public static class Spot {

        public int id;
        public VehicleType spotType;
        public boolean isOccupied;

        public Spot(int id, VehicleType spotType) {
            this.id = id;
            this.spotType = spotType;
            this.isOccupied = false;
        }
    }

    private final List<Spot> spots = new ArrayList<>();

    public void addSpot(Spot spot) {
        spots.add(spot);
    }

    public Spot parkVehicle(VehicleType type) {
        for (Spot spot : spots) {
            if (!spot.isOccupied && spot.spotType == type) {
                spot.isOccupied = true;
                return spot;
            }
        }
        return null;
    }

    public void leaveSpot(Spot spot) {
        spot.isOccupied = false;
    }
}
