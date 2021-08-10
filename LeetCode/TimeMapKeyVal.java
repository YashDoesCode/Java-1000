
import java.util.*;
public class TimeMapKeyVal {

    private Map<String, TreeMap<Integer, String>> mp = new HashMap<>();

    public void set(String key, String value, int timestamp) { mp.putIfAbsent(key, new TreeMap<>());
        mp.get(key).put(timestamp, value);
    } public String get(String key, int timestamp) { if (!mp.containsKey(key)) return "";
        Integer k = mp.get(key).floorKey(timestamp);
        return k == null ? "" : mp.get(key).get(k);
    };
}
