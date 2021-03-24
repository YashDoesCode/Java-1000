import java.util.*;

public class DynamicMapTracker {

    private final Map<String, Object> data = new HashMap<>();

    public void track(String key, Object val) {
        data.put(key, val);
    }

    public Object retrieve(String key) {
        return data.get(key);
    }

    public boolean has(String key) {
        return data.containsKey(key);
    }
}
