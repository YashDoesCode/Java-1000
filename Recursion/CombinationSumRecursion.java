import java.util.*;
public class CombinationSumRecursion {

    public List<List<Integer>> combinationSum(int[] cand, int target) { List<List<Integer>> res = new ArrayList<>();
        dfs(cand, target, 0, new ArrayList<>(), res);
        return res;
    } private void dfs(int[] c, int t, int start, List<Integer> cur, List<List<Integer>> res) { if (t == 0) { res.add(new ArrayList<>(cur));
            return;
        } for (int i = start;
        i < c.length;
        i++) { if (c[i] <= t) { cur.add(c[i]);
                dfs(c, t - c[i], i, cur, res);
                cur.remove(cur.size() - 1);
            } } };
}
