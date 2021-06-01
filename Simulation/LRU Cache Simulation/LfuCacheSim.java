import java.util.*;

public class LfuCacheSim<K, V> {

    private final int capacity;
    private int minFreq = 0;
    private final Map<K, V> keyToVal = new HashMap<>();
    private final Map<K, Integer> keyToFreq = new HashMap<>();
    private final Map<Integer, LinkedHashSet<K>> freqToKeys = new HashMap<>();

    public LfuCacheSim(int capacity) {
        this.capacity = capacity;
    }

    public V get(K key) {
        if (!keyToVal.containsKey(key)) return null;
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        freqToKeys.get(freq).remove(key);
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (minFreq == freq) minFreq++;
        }
        freqToKeys.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>()).add(key);
        return keyToVal.get(key);
    }

    public void put(K key, V value) {
        if (capacity <= 0) return;
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            get(key);
            return;
        }
        if (keyToVal.size() >= capacity) {
            K evict = freqToKeys.get(minFreq).iterator().next();
            freqToKeys.get(minFreq).remove(evict);
            keyToVal.remove(evict);
            keyToFreq.remove(evict);
        }
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        minFreq = 1;
        freqToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
    }
}
