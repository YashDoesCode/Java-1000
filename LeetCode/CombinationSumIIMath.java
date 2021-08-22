
import java.util.*;
public class CombinationSumIIMath {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) { Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return res;
    } private void dfs(int[] cand, int target, int start, List<Integer> cur, List<List<Integer>> res) { if (target == 0) { res.add(new ArrayList<>(cur));
            return;
        } for (int i = start;
        i < cand.length;
        i++) { if (i > start && cand[i] == cand[i - 1]) continue;
            if (cand[i] <= target) { cur.add(cand[i]);
                dfs(cand, target - cand[i], i + 1, cur, res);
                cur.remove(cur.size() - 1);
            } } };
}
