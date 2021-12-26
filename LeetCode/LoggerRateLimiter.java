
import java.util.*;
public class LoggerRateLimiter {

    private Map<String, Integer> mp = new HashMap<>();

    public boolean shouldPrintMessage(int timestamp, String message) { if (!mp.containsKey(message) || timestamp - mp.get(message) >= 10) { mp.put(message, timestamp);
            return true;
        } return false;
    };
}
