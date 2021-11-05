import java.util.*;
public class LFUCacheHashMap {

    private int cap, minFreq = 0;

    private Map<Integer, Integer> vals = new HashMap<>(), counts = new HashMap<>();

    private Map<Integer, LinkedHashSet<Integer>> lists = new HashMap<>();

    public LFUCacheHashMap(int capacity) { cap = capacity;
        lists.put(1, new LinkedHashSet<>());
    } public int get(int key) { if (!vals.containsKey(key)) return -1;
        int count = counts.get(key);
        counts.put(key, count + 1);
        lists.get(count).remove(key);
        if (count == minFreq && lists.get(count).isEmpty()) minFreq++;
        lists.putIfAbsent(count + 1, new LinkedHashSet<>());
        lists.get(count + 1).add(key);
        return vals.get(key);
    } public void put(int key, int value) { if (cap <= 0) return;
        if (vals.containsKey(key)) { vals.put(key, value);
            get(key);
            return;
        } if (vals.size() >= cap) { int evit = lists.get(minFreq).iterator().next();
            lists.get(minFreq).remove(evit);
            vals.remove(evit);
            counts.remove(evit);
        } vals.put(key, value);
        counts.put(key, 1);
        minFreq = 1;
        lists.get(1).add(key);
    };
}
