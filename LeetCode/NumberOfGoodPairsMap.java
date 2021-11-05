
import java.util.*;
public class NumberOfGoodPairsMap {

    public int numIdenticalPairs(int[] nums) { Map<Integer, Integer> mp = new HashMap<>();
        int ans = 0;
        for (int n : nums) { int cnt = mp.getOrDefault(n, 0);
            ans += cnt;
            mp.put(n, cnt + 1);
        } return ans;
    };
}
