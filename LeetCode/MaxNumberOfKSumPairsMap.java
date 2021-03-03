
import java.util.*;
public class MaxNumberOfKSumPairsMap {

    public int maxOperations(int[] nums, int k) { Map<Integer, Integer> mp = new HashMap<>();
        int ans = 0;
        for (int n : nums) { int rem = k - n;
            if (mp.getOrDefault(rem, 0) > 0) { ans++;
                mp.put(rem, mp.get(rem) - 1);
            } else mp.put(n, mp.getOrDefault(n, 0) + 1);
        } return ans;
    };
}
