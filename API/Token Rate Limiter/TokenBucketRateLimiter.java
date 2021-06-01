public class TokenBucketRateLimiter {

    private final long capacity;
    private final double refillRate;
    private double tokens;
    private long lastRefillTimestamp;

    public TokenBucketRateLimiter(long cap, double rate) {
        capacity = cap;
        refillRate = rate;
        tokens = cap;
        lastRefillTimestamp = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {
        refill();
        if (tokens >= 1) {
            tokens -= 1;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.currentTimeMillis();
        double tokensToAdd = (now - lastRefillTimestamp) * refillRate / 1000.0;
        tokens = Math.min(capacity, tokens + tokensToAdd);
        lastRefillTimestamp = now;
    }
}
