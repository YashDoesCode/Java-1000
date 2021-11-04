
import java.util.*;
public class CountPairsDiffK {

    public int findPairs(int[] nums, int k) { if (k < 0) return 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int n : nums) mp.put(n, mp.getOrDefault(n, 0) + 1);
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) { if (k == 0) { if (entry.getValue() >= 2) cnt++;
            } else { if (mp.containsKey(entry.getKey() + k)) cnt++;
            } } return cnt;
    };
}
