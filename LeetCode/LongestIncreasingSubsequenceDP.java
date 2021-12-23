
import java.util.*;
public class LongestIncreasingSubsequenceDP {

    public int lengthOfLIS(int[] nums) { int[] tails = new int[nums.length];
        int len = 0;
        for (int x : nums) { int i = 0, j = len;
            while (i < j) { int mid = (i + j) / 2;
                if (tails[mid] < x) i = mid + 1;
                else j = mid;
            } tails[i] = x;
            if (i == len) len++;
        } return len;
    };
}
