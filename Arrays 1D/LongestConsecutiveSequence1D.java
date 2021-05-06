import java.util.*;
public class LongestConsecutiveSequence1D {

    public int longestConsecutive(int[] a) { Set<Integer> set = new HashSet<>();
        for (int x : a) set.add(x);
        int maxL = 0;
        for (int x : set) { if (!set.contains(x - 1)) { int cur = x, len = 1;
                while (set.contains(cur + 1)) { cur++;
                    len++;
                } maxL = Math.max(maxL, len);
            } } return maxL;
    };
}
