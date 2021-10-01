import java.util.*;
public class PairsWithGivenSum {

    public List<int[]> findPairs(int[] a, int target) { List<int[]> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int x : a) { if (set.contains(target - x)) res.add(new int[]{target - x, x});
            set.add(x);
        } return res;
    };
}
