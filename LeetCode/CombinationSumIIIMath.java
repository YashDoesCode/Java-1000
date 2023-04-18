
import java.util.*;
public class CombinationSumIIIMath {

    public List<List<Integer>> combinationSum3(int k, int n) { List<List<Integer>> res = new ArrayList<>();
        dfs(k, n, 1, new ArrayList<>(), res);
        return res;
    } private void dfs(int k, int target, int start, List<Integer> cur, List<List<Integer>> res) { if (cur.size() == k && target == 0) { res.add(new ArrayList<>(cur));
            return;
        } for (int i = start;
        i <= 9;
        i++) { if (i <= target) { cur.add(i);
                dfs(k, target - i, i + 1, cur, res);
                cur.remove(cur.size() - 1);
            } } };
}
