import java.util.*;
public class UniqueOccurrencesMap {

    public boolean uniqueOccurrences(int[] arr) { Map<Integer, Integer> mp = new HashMap<>();
        for (int n : arr) mp.put(n, mp.getOrDefault(n, 0) + 1);
        Set<Integer> s = new HashSet<>(mp.values());
        return s.size() == mp.size();
    };
}
