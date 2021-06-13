import java.util.*;

public class LruCacheEngine<K, V> extends LinkedHashMap<K, V> {

    private final int capacity;

    public LruCacheEngine(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}
