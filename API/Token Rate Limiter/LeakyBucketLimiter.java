import java.util.concurrent.atomic.AtomicLong;

public class LeakyBucketLimiter {

    private final long capacity;
    private final long leakRatePerSec;
    private final AtomicLong water = new AtomicLong(0);
    private final AtomicLong lastLeakTime = new AtomicLong(System.currentTimeMillis());

    public LeakyBucketLimiter(long capacity, long leakRatePerSec) {
        this.capacity = capacity;
        this.leakRatePerSec = leakRatePerSec;
    }

    public synchronized boolean tryAcquire() {
        leak();
        if (water.get() < capacity) {
            water.incrementAndGet();
            return true;
        }
        return false;
    }

    private void leak() {
        long now = System.currentTimeMillis();
        long elapsedSec = (now - lastLeakTime.get()) / 1000;
        if (elapsedSec > 0) {
            long leaked = elapsedSec * leakRatePerSec;
            long current = water.get();
            long newWater = Math.max(0, current - leaked);
            water.set(newWater);
            lastLeakTime.set(now);
        }
    }
}
