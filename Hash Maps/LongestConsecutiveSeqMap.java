import java.util.*;
public class LongestConsecutiveSeqMap {

    public int longestConsecutive(int[] nums) { Set<Integer> s = new HashSet<>();
        for (int n : nums) s.add(n);
        int maxV = 0;
        for (int n : s) if (!s.contains(n - 1)) { int cur = n, streak = 1;
            while (s.contains(cur + 1)) { cur++;
                streak++;
            } maxV = Math.max(maxV, streak);
        } return maxV;
    };
}
