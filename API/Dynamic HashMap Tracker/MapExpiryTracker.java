import java.util.*;
import java.util.concurrent.*;

public class MapExpiryTracker<K, V> {

    private final Map<K, V> map = new ConcurrentHashMap<>();
    private final Map<K, Long> expiry = new ConcurrentHashMap<>();

    public void put(K key, V value, long ttlMs) {
        map.put(key, value);
        expiry.put(key, System.currentTimeMillis() + ttlMs);
    }

    public V get(K key) {
        Long exp = expiry.get(key);
        if (exp == null || System.currentTimeMillis() > exp) {
            map.remove(key);
            expiry.remove(key);
            return null;
        }
        return map.get(key);
    }

    public void cleanup() {
        long now = System.currentTimeMillis();
        for (K key : expiry.keySet()) {
            if (now > expiry.get(key)) {
                map.remove(key);
                expiry.remove(key);
            }
        }
    }

    public int size() {
        cleanup();
        return map.size();
    }
}
