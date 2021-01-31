public class LeakyBucketRateLimiter {

    private final int capacity;
    private int currentWater = 0;

    public LeakyBucketRateLimiter(int cap) {
        capacity = cap;
    }

    public synchronized boolean addPacket() {
        if (currentWater < capacity) {
            currentWater++;
            return true;
        }
        return false;
    }

    public synchronized void leak() {
        if (currentWater > 0) currentWater--;
    }
}
