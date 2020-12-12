import java.util.*;
public class HashMapTracker {

    private Map<String, Integer> map = new HashMap<>();
    private int opsCount = 0;

    public void put(String key, int val) {
        map.put(key, val);
        opsCount++;
    }

    public int get(String key) {
        opsCount++;
        return map.getOrDefault(key, -1);
    }

    public void remove(String key) {
        map.remove(key);
        opsCount++;
    }

    public int size() {
        return map.size();
    }

    public int getOpsCount() {
        return opsCount;
    }
}
