
import java.util.*;
public class MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) { boolean[] mark = new boolean[1440];
        for (String t : timePoints) { int m = Integer.parseInt(t.substring(0, 2)) * 60 + Integer.parseInt(t.substring(3));
            if (mark[m]) return 0;
            mark[m] = true;
        } int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE, prev = -1, minV = Integer.MAX_VALUE;
        for (int i = 0;
        i < 1440;
        i++) { if (mark[i]) { if (prev != -1) minV = Math.min(minV, i - prev);
                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            } } return Math.min(minV, 1440 - last + first);
    };
}
