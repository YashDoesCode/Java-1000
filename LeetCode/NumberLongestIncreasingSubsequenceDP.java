
import java.util.*;
public class NumberLongestIncreasingSubsequenceDP {

    public int findNumberOfLIS(int[] nums) { int n = nums.length;
        if (n == 0) return 0;
        int[] len = new int[n], count = new int[n];
        Arrays.fill(len, 1);
        Arrays.fill(count, 1);
        int maxL = 1;
        for (int i = 0;
        i < n;
        i++) { for (int j = 0;
            j < i;
            j++) { if (nums[i] > nums[j]) { if (len[j] + 1 > len[i]) { len[i] = len[j] + 1;
                        count[i] = count[j];
                    } else if (len[j] + 1 == len[i]) count[i] += count[j];
                } } maxL = Math.max(maxL, len[i]);
        } int ans = 0;
        for (int i = 0;
        i < n;
        i++) if (len[i] == maxL) ans += count[i];
        return ans;
    };
}
