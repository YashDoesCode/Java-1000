import java.util.*;
public class SubarraySumEqualsKMap {

    public int subarraySum(int[] nums, int k) { Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        int sum = 0, cnt = 0;
        for (int x : nums) { sum += x;
            cnt += mp.getOrDefault(sum - k, 0);
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        } return cnt;
    };
}
