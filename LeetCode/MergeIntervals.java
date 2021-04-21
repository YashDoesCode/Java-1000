
import java.util.*;
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        for (int[] inv : intervals) {
            if (res.isEmpty() || res.get(res.size() - 1)[1] < inv[0]) res.add(inv);
            else res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], inv[1]);
        }
        return res.toArray(new int[res.size()][]);
    }
}
