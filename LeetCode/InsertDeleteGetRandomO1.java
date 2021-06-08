
import java.util.*;
public class InsertDeleteGetRandomO1 {

    private Map<Integer, Integer> mp = new HashMap<>();

    private List<Integer> list = new ArrayList<>();

    private Random rand = new Random();

    public boolean insert(int val) { if (mp.containsKey(val)) return false;
        mp.put(val, list.size());
        list.add(val);
        return true;
    } public boolean remove(int val) { if (!mp.containsKey(val)) return false;
        int idx = mp.get(val), last = list.get(list.size() - 1);
        list.set(idx, last);
        mp.put(last, idx);
        list.remove(list.size() - 1);
        mp.remove(val);
        return true;
    } public int getRandom() { return list.get(rand.nextInt(list.size()));
    };
}
