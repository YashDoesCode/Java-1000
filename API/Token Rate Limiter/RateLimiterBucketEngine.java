public class RateLimiterBucketEngine {

    private final int maxTokens;
    private int currentTokens;

    public RateLimiterBucketEngine(int maxTokens) {
        this.maxTokens = maxTokens;
        this.currentTokens = maxTokens;
    }

    public synchronized boolean grantToken() {
        if (currentTokens > 0) {
            currentTokens--;
            return true;
        }
        return false;
    }

    public synchronized void refill() {
        currentTokens = maxTokens;
    }
}
