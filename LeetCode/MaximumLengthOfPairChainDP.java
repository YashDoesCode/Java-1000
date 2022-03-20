
import java.util.*;
public class MaximumLengthOfPairChainDP {

    public int findLongestChain(int[][] pairs) { Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int cur = Integer.MIN_VALUE, ans = 0;
        for (int[] p : pairs) { if (p[0] > cur) { cur = p[1];
                ans++;
            } } return ans;
    };
}
