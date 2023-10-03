
import java.util.*;
public class LongestArithmeticSubsequenceDP {

    public int longestArithSeqLength(int[] nums) { int n = nums.length, maxV = 0;
        Map<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0;
        i < n;
        i++) { dp[i] = new HashMap<>();
            for (int j = 0;
            j < i;
            j++) { int diff = nums[i] - nums[j];
                int len = dp[j].getOrDefault(diff, 1) + 1;
                dp[i].put(diff, len);
                maxV = Math.max(maxV, len);
            } } return maxV;
    };
}
