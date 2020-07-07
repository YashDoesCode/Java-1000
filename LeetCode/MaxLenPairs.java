
import java.util.*;
public class MaxLenPairs {

    public int findLongestChain(int[][] pairs) { Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int cur = Integer.MIN_VALUE, cnt = 0;
        for (int[] p : pairs) { if (p[0] > cur) { cur = p[1];
                cnt++;
            } } return cnt;
    };
}
